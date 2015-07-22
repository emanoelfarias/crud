package br.com.projetoproint.dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;



public class HibernateUtil {
	
	private static SessionFactory sessionFactory=null;
	private static ServiceRegistry serviceRegistry=null;

	public static SessionFactory createSessionFactory() {
		
		
		
		if(sessionFactory == null || serviceRegistry == null)
		{
			
	    Configuration configuration = new Configuration();
	    configuration.configure();
	    serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
	            configuration.getProperties()).build();
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	  
	    return sessionFactory;
		}
		else{
	    return sessionFactory;
		}
	}
}
