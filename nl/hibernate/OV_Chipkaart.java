package hibernate;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.sql.Date;
@Entity  
@Table(name="ov_chipkaart")  
public class OV_Chipkaart {
    @Id  
    @GeneratedValue  
	private int kaartNummer;
	private Date geldigTot;
	private int klasse;
	private double saldo;
	@ManyToOne
	@JoinColumn(name="reizigerid")
	private Reiziger reiziger;
	private int reizigerID;
	
	public OV_Chipkaart() {
	}
	
	public OV_Chipkaart(int kaarNummer, Date geldigTot, int klasse, double saldo, Reiziger reiziger) {
		this.kaartNummer = kaarNummer;
		this.geldigTot = geldigTot;
		this.klasse = klasse;
		this.saldo = saldo;
		this.reiziger = reiziger;
		this.reizigerID = reiziger.getReizigerID();
	}
	public OV_Chipkaart(int kaarNummer, Date geldigTot, int klasse, double saldo) {
		this.kaartNummer = kaarNummer;
		this.geldigTot = geldigTot;
		this.klasse = klasse;
		this.saldo = saldo;
	}


	public int getKaartNummer() {
		return kaartNummer;
	}

	public void setKaartNummer(int kaartNummer) {
		this.kaartNummer = kaartNummer;
	}

	public Date getGeldigTot() {
		return geldigTot;
	}

	public void setGeldigTot(Date geldigTot) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		this.geldigTot = geldigTot;
	}

	public int getKlasse() {
		return klasse;
	}

	public void setKlasse(int klasse) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		this.klasse = klasse;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		this.saldo = saldo;
	}

	public Reiziger getReiziger() {
		return reiziger;
	}
	

	public void setReiziger(Reiziger reiziger) {
		this.reiziger = reiziger;
	}

	public int getReizigerID() {
		return reizigerID;
	}

	public void setReizigerID(int reizigerID) {
		this.reizigerID = reizigerID;
	}

	@Override
	public String toString() {
		return "OV_Chipkaart [kaartNummer=" + kaartNummer + ", geldigTot="
				+ geldigTot + ", klasse=" + klasse + ", saldo=" + saldo
				+ ", reiziger=" + reiziger + ", reizigerID=" + reizigerID + "]";
	}



	
	
}
