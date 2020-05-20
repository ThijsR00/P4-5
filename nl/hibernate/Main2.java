package hibernate;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

public class Main2 {
  public static void main(String[] args) throws SQLException, ParseException, InstantiationException, IllegalAccessException, ClassNotFoundException {
      HibernateOV_ChipkaartDAO hod = new HibernateOV_ChipkaartDAO();
      HibernateReizigerDAO hrd = new HibernateReizigerDAO();
      Reiziger r = new Reiziger(1018, "fasdf", "asdfa", "asdfa", new Date(2015-03-30), null);
      OV_Chipkaart i = new OV_Chipkaart(104, new Date(15-05-22), 2, 20.50, r);
      hrd.save(r); //create reiziger
      hod.save(i); //create ov
      i.setKlasse(1);
      r.setAchternaam("thissoe");
      hod.update(i); //update ov
      hrd.update(r); //update reiziger
      System.out.println(hod.get(i.getKaartNummer())); //get ov
      System.out.println(hrd.get(r.getReizigerID())); //get reiziger
	  hod.delete(i); //delete ov 
	  hrd.delete(r); //delete reiziger
	}
}
