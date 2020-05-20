package hibernate;

import java.sql.Date;
import java.sql.SQLException;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity  
@Table(name="reiziger")  
public class Reiziger {
	@Id
	@GeneratedValue
	private int reizigerID;
	private String voorletters;
	private String tussenvoegsel;
	private String achternaam;
	private Date gbdatum;
	@OneToMany(mappedBy="reiziger", targetEntity = OV_Chipkaart.class, cascade = CascadeType.ALL)
	private List<OV_Chipkaart> kaarten;
	
	public Reiziger() {
	}
	
	public Reiziger(int reizigerID, String voorletters, String tussenvoegsel, String achternaam, Date gbdatum, Set<OV_Chipkaart> kaarten) {

		this.reizigerID = reizigerID;
		this.voorletters = voorletters;
		this.tussenvoegsel = tussenvoegsel;
		this.achternaam = achternaam;
		this.gbdatum = gbdatum;
		this.kaarten = kaarten;
	}

	public int getReizigerID() {
		return reizigerID;
	}
	public void setReizigerID(int reizigerID) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		this.reizigerID = reizigerID;
	}
	public String getVoorletters() {
		return voorletters;
	}
	public void setVoorletters(String voorletters) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		this.voorletters = voorletters;
	}
	public String getTussenvoegsel() {
		return tussenvoegsel;
	}
	public void setTussenvoegsel(String tussenvoegsel) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		this.tussenvoegsel = tussenvoegsel;
	}
	public String getAchternaam() {
		return achternaam;
	}
	public void setAchternaam(String achternaam) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		this.achternaam = achternaam;
	}
	public Date getGbdatum() {
		return gbdatum;
	}
	public void setGbdatum(Date gbdatum) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		this.gbdatum = gbdatum;
	}

	public Collection<OV_Chipkaart> getKaarten() {
		return kaarten;
	}

	public void setKaarten(Set<OV_Chipkaart> kaarten) {
		this.kaarten = kaarten;
	}

	public void addKaart(hibernate.OV_Chipkaart ov_Chipkaart) {
		this.kaarten.add(new OV_Chipkaart(ov_Chipkaart.getKaartNummer(), ov_Chipkaart.getGeldigTot(), ov_Chipkaart.getKlasse(), ov_Chipkaart.getSaldo()));
	}
	
	public void deleteKaart(OV_Chipkaart ov) {
		for (OV_Chipkaart ovc : kaarten) {
			if(ovc.getKaartNummer() == ov.getKaartNummer()) {
				kaarten.remove(ovc);
			}
		}
	}

	@Override
	public String toString() {
		return "Reiziger [reizigerID=" + reizigerID + ", voorletters="
				+ voorletters + ", tussenvoegsel=" + tussenvoegsel
				+ ", achternaam=" + achternaam + ", gbdatum=" + gbdatum
				+ ", kaarten=" + kaarten + "]";
	}
	
}
