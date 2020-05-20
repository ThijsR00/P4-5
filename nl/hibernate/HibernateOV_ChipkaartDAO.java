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

public class HibernateOV_ChipkaartDAO implements OV_ChipkaartDAO{
	private static SessionFactory factory;
	@Override
	public void save(OV_Chipkaart ov) {
		try {
	        factory = new Configuration().configure().buildSessionFactory();
	      } catch (Throwable ex) {
	        System.err.println("Failed to create sessionFactory object." + ex);
	        throw new ExceptionInInitializerError(ex);
	      }
		Session session = factory.openSession();
	    Transaction t = session.beginTransaction();
	    session.save(ov);
	    t.commit();
	    factory.close();  
	    session.close(); 
	}

	@Override
	public void delete(OV_Chipkaart ov) {
		try {
	        factory = new Configuration().configure().buildSessionFactory();
	      } catch (Throwable ex) {
	        System.err.println("Failed to create sessionFactory object." + ex);
	        throw new ExceptionInInitializerError(ex);
	      }
		Session session = factory.openSession();
	    Transaction t = session.beginTransaction();
	    session.delete(ov);
	    t.commit();
	    factory.close();  
	    session.close(); 
		
	}

	@Override
	public void update(OV_Chipkaart ov) {
		try {
	        factory = new Configuration().configure().buildSessionFactory();
	      } catch (Throwable ex) {
	        System.err.println("Failed to create sessionFactory object." + ex);
	        throw new ExceptionInInitializerError(ex);
	      }
		Session session = factory.openSession();
	    Transaction t = session.beginTransaction();
	    session.saveOrUpdate(ov);
	    t.commit();
	    factory.close();  
	    session.close(); 
		
	}

	@Override
	public OV_Chipkaart get(int nummer) {
		try {
	        factory = new Configuration().configure().buildSessionFactory();
	      } catch (Throwable ex) {
	        System.err.println("Failed to create sessionFactory object." + ex);
	        throw new ExceptionInInitializerError(ex);
	      }
		Session session = factory.openSession();
	    Transaction t = session.beginTransaction();
	    OV_Chipkaart ov = session.get(OV_Chipkaart.class, nummer);
	    factory.close();  
	    session.close();
		return ov; 
	}

}
