package com.horphelinat.backend.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orphelin")
public class Orphelin  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private long id;
	@Column(name = "nom")
	private String nom;	
	@Column(name = "prenom")
	private String prenom;	
	@Column(name = "sexe")
	private String sexe;	
	@Column(name = "adresse")
	private String adresse;
	@Column(name = "photo")
	private String photo;
	@Column(name = "isactive")
	private Boolean isactive;
	@Column(name = "datenaissance")
    private Date datenaissance;	
	@Column(name = "dateentree")
	private Date dateentree;	
	@Column(name = "situation")
    private String situation;
	@Column(name = "infossup")
    private String infossup;
	@JoinColumn(name = "usercreateur", referencedColumnName = "id")
	@ManyToOne
	private Users usercreateur;
	
	@JoinColumn(name = "tuteur", referencedColumnName = "id")
	@ManyToOne
	private Tuteur tuteur;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Boolean getIsactive() {
		return isactive;
	}
	public void setIsactive(Boolean isactive) {
		this.isactive = isactive;
	}
	public Date getDatenaissance() {
		return datenaissance;
	}
	public void setDatenaissance(Date datenaissance) {
		this.datenaissance = datenaissance;
	}
	public Date getDateentree() {
		return dateentree;
	}
	public void setDateentree(Date dateentree) {
		this.dateentree = dateentree;
	}
	public String getSituation() {
		return situation;
	}
	public void setSituation(String situation) {
		this.situation = situation;
	}
	public String getInfossup() {
		return infossup;
	}
	public void setInfossup(String infossup) {
		this.infossup = infossup;
	}
	public Users getUsercreateur() {
		return usercreateur;
	}
	public void setUsercreateur(Users usercreateur) {
		this.usercreateur = usercreateur;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Tuteur getTuteur() {
		return tuteur;
	}
	public void setTuteur(Tuteur tuteur) {
		this.tuteur = tuteur;
	}
	public Orphelin(long id, String nom, String prenom, String sexe, String adresse, String photo, Boolean isactive,
			Date datenaissance, Date dateentree, String situation, String infossup, Users usercreateur, Tuteur tuteur) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.adresse = adresse;
		this.photo = photo;
		this.isactive = isactive;
		this.datenaissance = datenaissance;
		this.dateentree = dateentree;
		this.situation = situation;
		this.infossup = infossup;
		this.usercreateur = usercreateur;
		this.tuteur = tuteur;
	}
	public Orphelin() {
		super();
	}
	
	
	
	  
}
