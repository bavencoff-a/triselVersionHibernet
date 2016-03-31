package com.metier;
import java.util.Date;

import javax.persistence.*;

import com.persistance.*;

@Entity
@Table(name="levee")
@Inheritance (strategy=InheritanceType.JOINED)
public class Levee {
	@Id
	@GeneratedValue
	@Column (name="idLevee")
	private int idLevee;
	
	@Column (name="laDate")
	private Date laDate;
	
	@Column (name="poids")
	private double poids;
	
	@Column (name="idPoubelle")
	String idP;
	

	
/**
 * Constructeur de Levee avec l'idPoubelle
 * @param idLevee int
 * @param laDate Date
 * @param poids Double
 * @param idPoub
 */
	public Levee() {
		super();
		
	}
/**
 * Constructeur de Levee avec l'idPoubelle
 * @param idLevee int
 * @param laDate Date
 * @param poids Double
 * @param idPoub
 */
	public Levee(int idLevee, Date laDate, double poids,String idPoub) {
		super();
		this.idLevee = idLevee;
		this.laDate = laDate;
		this.poids = poids;
		this.idP = idPoub;
	}
	/**
	 * Constructeur de Levee sans l'idPoubelle
	 * @param idLevee int
	 * @param laDate Date
	 * @param poids Double
	 */
	public Levee(int idLevee, Date laDate, double poids) {
		super();
		this.idLevee = idLevee;
		this.laDate = laDate;
		this.poids = poids;
	
	}
	/**
	 * Constructeur sans l'idLevee
	 * @param laDate Date
	 * @param poids Double
	 * @param idPoub int
	 */
	public Levee(Date laDate, double poids,String idPoub) {
		super();
		this.laDate = laDate;
		this.poids = poids;
		this.idP = idPoub;
	}
	/**
	 * getLaDate
	 * @return Date laDate
	 */
	public Date getLaDate() {
		return laDate;
	}
	/**
	 * setLaDate
	 * @param laDate : modifie la date
	 */
	public void setLaDate(Date laDate) {
		this.laDate = laDate;
	}
	/**
	 * getPoids
	 * @return double poids
	 */
	public double getPoids() {
		return poids;
	}
	/**
	 * setPoids
	 * @param poids (double): modifie le poids 
	 */
	public void setPoids(double poids) {
		this.poids = poids;
	}
	/**
	 * getIdLevee
	 * @return int idLevee
	 */
	public int getIdLevee() {
		return idLevee;
	}
	/**
	 * getIdPoubelle
	 * @return String idP
	 */
	public String getIdPoubelle() {
		return idP;
	}
/**
 * SetIdPoubelle
 * @param idP (String) modifie l'idPoubelle
 */
	public void SetIdPoubelle(String idP) {
		this.idP = idP;
	}
/**
 * ToString
 */
	@Override
	public String toString() {
		return "Levee [idLevee=" + idLevee + ", laDate=" + laDate + ", poids=" + poids + "]";
	}
public String getIdP() {
	return idP;
}
public void setIdP(String idP) {
	this.idP = idP;
}
public void setIdLevee(int idLevee) {
	this.idLevee = idLevee;
}
	
}
