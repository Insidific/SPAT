package Controller;

import java.io.File;
import java.util.Set;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import Model.Data;
import Model.TheSession;
import Views.UIApp;

public class Sensored 
{
	private static TheSession currentDataSession = null;
	private static Session currentDatabaseSession = null;
	private static int databaseSessionUsers = 0;
	private static SessionFactory sessionFactory;
	private static SerialManager serialManager;
	private static UIApp ui;
	private static Logging log;
	
	/**
	 * This is the program start point.
	 * @param args the command line arguments.
	 */
	public static void main(String[] args)
	{
	    
		setupDB();
		serialManager = new SerialManager();
		ui = new UIApp();
		ui.setVisible(true);
		log = new Logging();
	}

	/**
	 * This method is used to establish a database connection.
	 */
	private static void setupDB()
	{
		System.out.println("Setting up database connection...");
		System.out.println(System.getProperty("user.dir"));
		File configFile = new File("./hibernate.cfg.xml");
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
			.configure(configFile) // configures settings from hibernate.cfg.xml
			.build();
		System.out.println("Loaded configuration ("+configFile.getAbsolutePath()+").");
	    sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
	    System.out.println("Done!");
	}
	
	/**
	 * This method returns a database session; this is used for all interactions with the database.
	 * Please remember to call doneWithDatabaseSession() after you are done with the Session object returned.
	 * @return a database session, either new or re-used.
	 */
	public static Session getDatabaseSession()
	{
		databaseSessionUsers++;
		if (currentDatabaseSession == null)
			currentDatabaseSession = sessionFactory.openSession();
		return currentDatabaseSession;
	}
	
	/**
	 * This method is used to possibly dispose of the database session, depending on need. 
	 * It should be called once at some point after every call to getDatabaseSession().
	 */
	public static void doneWithDatabaseSession()
	{
		databaseSessionUsers--;
		if (databaseSessionUsers == 0)
		{
			currentDatabaseSession.close();
			currentDatabaseSession = null;
		}
	}
	
	/**
	 * This method is used to start a new data session (TheSession).
	 */
	public static void startDataSession()
	{
		if (currentDataSession == null)
		{
		    System.out.println("Starting data session.");
			currentDataSession = new TheSession();
			currentDataSession.start();
			Session session = getDatabaseSession();
			session.beginTransaction();
			session.save(currentDataSession);
			session.getTransaction().commit();
			doneWithDatabaseSession();
			System.out.println("Data session started!");
		}
		else
		{
			throw new IllegalStateException("There is already a session in progress!");
		}
	}
	
	/**
	 * This method is used to stop the current data session (TheSession)
	 */
	public static void stopDataSession()
	{
		if (currentDataSession != null)
		{
		    	System.out.println("Stopping data session.");
			currentDataSession.stop();
			Session session = getDatabaseSession();
			session.beginTransaction();
			session.update(currentDataSession);
			session.getTransaction().commit();
			doneWithDatabaseSession();
			currentDataSession = null;
			System.out.println("Data session stopped.");
		}
		else
		{
			throw new IllegalStateException("There is no current session to stop!");
		}
	}
	
	/**
	 * This method is used to check if there is a data session in progress.
	 * @return true if there is currently a data session, or false if not.
	 */
	public static boolean isDataSessionRunning()
	{
	    return currentDataSession != null;
	}
	
	/**
	 * Retreives and returns the currently running data session (TheSession), or throws an 
	 * @return
	 */
	public static TheSession getCurrentDataSession() {
		if(currentDataSession != null)
			return currentDataSession;
		else
			throw new IllegalStateException("No current session!");
	}

	/**
	 * This method returns the current instance of SerialManager. It is primarily intended to be used by the UI.
	 * @return the current SerialManager in use.
	 */
	public static SerialManager getSerialManager() {
		return serialManager;
	}
	
	/**
	 * This method should be called - by SerialManager - when a new data line has been received.
	 * @param dataline the data line that was 
	 */
	public static void newDataReceived(String dataline)
	{
		Set<Data> datas = Data.parseData(dataline);
		ui.newRawData(dataline);
		log.newRawData(dataline);
		for (Data data : datas)
		{
			ui.newParsedData(data);
		}
	}
	
	
}
