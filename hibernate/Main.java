package hibernate;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;



import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.boot.Metadata;  
import org.hibernate.boot.MetadataSources;  
import org.hibernate.boot.registry.StandardServiceRegistry;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import oracle.jdbc.logging.annotations.*;

//er mag maar 1 record van user in de db staan
public class Main {
  private static SessionFactory factory;
  public static void main(String[] args) throws SQLException, ParseException {
      try {
        factory = new Configuration().configure().buildSessionFactory();
      } catch (Throwable ex) {
        System.err.println("Failed to create sessionFactory object." + ex);
        throw new ExceptionInInitializerError(ex);
      }
      Session session = factory.openSession();
      Transaction t = session.beginTransaction();
      User user = new User("thijs", "rijnders");
      session.save(user); //create
      System.out.println(session.get(User.class, "thijs")); //read
      user.setPassword("tee");
      session.update(user); //update
      session.delete(user); //delete
      t.commit();
      factory.close();  
      session.close();   
  }
}
