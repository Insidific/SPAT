package Controller;

import java.io.File;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import Model.TheSession;

public class Sensored 
{
	private static TheSession currentDataSession = null;
	private static SessionFactory sessionFactory;
	
	public static void main(String[] args)
	{
		setupDB();
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
		try
		{
		    sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		    System.out.println("Done!");
		} finally
		{
		    StandardServiceRegistryBuilder.destroy(registry);
		}
	}
	
	public static Session getSession() {
		throw new UnsupportedOperationException("NYI!");
	}
	
	public static TheSession getDataSession()
	{
		if(currentDataSession != null)
			return currentDataSession;
		else
			throw new IllegalStateException("No current session!");
	}

	public static void doneWithSession() {
		// TODO Auto-generated method stub
		
	}
	
	
}
