package hibernate;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.Serializable;
import java.sql.Date;


import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.boot.Metadata;  
import org.hibernate.boot.MetadataSources;  
import org.hibernate.boot.registry.StandardServiceRegistry;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import oracle.jdbc.logging.annotations.*;

public class HibernateReizigerDAO implements ReizigerDAO{
	private static SessionFactory factory;
	@Override
	public void save(Reiziger r) {
		try {
	        factory = new Configuration().configure().buildSessionFactory();
	      } catch (Throwable ex) {
	        System.err.println("Failed to create sessionFactory object." + ex);
	        throw new ExceptionInInitializerError(ex);
	      }
		Session session = factory.openSession();
	    Transaction t = session.beginTransaction();
	    session.save(r);
	    t.commit();
	    factory.close();  
	    session.close(); 
	}

	@Override
	public void delete(Reiziger r) {
		try {
	        factory = new Configuration().configure().buildSessionFactory();
	      } catch (Throwable ex) {
	        System.err.println("Failed to create sessionFactory object." + ex);
	        throw new ExceptionInInitializerError(ex);
	      }
		Session session = factory.openSession();
	    Transaction t = session.beginTransaction();
	    session.delete(r);
	    t.commit();
	    factory.close();  
	    session.close(); 
		
	}

	@Override
	public void update(Reiziger r) {
		try {
	        factory = new Configuration().configure().buildSessionFactory();
	      } catch (Throwable ex) {
	        System.err.println("Failed to create sessionFactory object." + ex);
	        throw new ExceptionInInitializerError(ex);
	      }
		Session session = factory.openSession();
	    Transaction t = session.beginTransaction();
	    session.saveOrUpdate(r);
	    t.commit();
	    factory.close();  
	    session.close(); 
		
	}

	@Override
	public Reiziger get(int nummer) {
		try {
	        factory = new Configuration().configure().buildSessionFactory();
	      } catch (Throwable ex) {
	        System.err.println("Failed to create sessionFactory object." + ex);
	        throw new ExceptionInInitializerError(ex);
	      }
		Session session = factory.openSession();
	    Transaction t = session.beginTransaction();
	    Reiziger r= session.get(Reiziger.class, nummer);
	    factory.close();  
	    session.close();
		return r; 
	}

}
