package Controller;

import java.io.File;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

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
	
	public static void main(String[] args)
	{
		setupDB();
		serialManager = new SerialManager();
		ui = new UIApp();
		ui.setVisible(true);
				
	}

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
	
	public static Session getDatabaseSession()
	{
		databaseSessionUsers++;
		if (currentDatabaseSession == null)
			currentDatabaseSession = sessionFactory.openSession();
		return currentDatabaseSession;
	}
	
	public static void doneWithDatabaseSession()
	{
		databaseSessionUsers--;
		if (databaseSessionUsers == 0)
		{
			currentDatabaseSession.close();
			currentDatabaseSession = null;
		}
	}
	
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
	
	public static void stopDataSession()
	{
		if (currentDataSession != null)
		{
		    	System.out.println("Stopping data session.");
			currentDataSession.stop();
			Session session = getDatabaseSession();
			session.beginTransaction();
			session.saveOrUpdate(currentDataSession);
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
	
	public static boolean isDataSessionRunning()
	{
	    return currentDataSession != null;
	}
	

	public static TheSession getCurrentDataSession() {
		if(currentDataSession != null)
			return currentDataSession;
		else
			throw new IllegalStateException("No current session!");
	}

	public static SerialManager getSerialManager() {
		return serialManager;
	}
	
	
	
	
}
