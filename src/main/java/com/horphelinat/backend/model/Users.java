package com.horphelinat.backend.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


@Entity
@Table(	name = "users", 
uniqueConstraints = { 
	@UniqueConstraint(columnNames = "username"),
	@UniqueConstraint(columnNames = "email") 
})
public class Users implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   @Basic(optional = false)
	   @Column(name = "id")
	   private long id;
	   @Column(name = "username")
	   private String username;
	   @Column(name = "password")
	   private String password;
	   @Column(name = "nbpasswordchanged")
	   private int nbpasswordchanged;
	   @Column(name = "datecreation")
	   private Date datecreation;
	   @Column(name = "dateupdate")
	   private Date dateupdate;
	   @Column(name = "nom")
	   private String nom;
	   @Column(name = "prenom")
	   private String prenom;
	   @Column(name = "telephone")
	   private String telephone;
	   @Column(name = "sexe")
	   private String sexe;
	   @Column(name = "photo")
	   private String photo;
	   @Column(name = "email")
	   private String email;
	   @Column(name = "cni")
	   private String cni;
	   @Column(name = "isactive")
	   private Boolean isactive;
	   @Column(name = "isdelete")
	   private Boolean isdelete;
	   @Column(name = "adresse",nullable = true)
	   private String adresse;
	   @Column(name = "datenaissance")
	   private Date datenaissance;
	   @Column(name = "profile")
	   private String profile;
	   

	public String getProfile() {
		return profile;
	}



	public void setProfile(String profile) {
		this.profile = profile;
	}



	public Users() {
		super();
	}
	 
	 








	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getIsactive() {
		return isactive;
	}

	public void setIsactive(Boolean isactive) {
		this.isactive = isactive;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String login) {
		this.username = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDatecreation() {
		return datecreation;
	}
	public void setDatecreation(Date datecreation) {
		this.datecreation = datecreation;
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
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public Boolean getIsdelete() {
		return isdelete;
	}



	public void setIsdelete(Boolean isdelete) {
		this.isdelete = isdelete;
	}



	public Users(long id, String username, String password, int nbpasswordchanged, Date datecreation, Date dateupdate,
			String nom, String prenom, String telephone, String sexe, String email, String cni, Boolean isactive,
			Boolean isdelete, String adresse, Date datenaissance, String profile) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.nbpasswordchanged = nbpasswordchanged;
		this.datecreation = datecreation;
		this.dateupdate = dateupdate;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.sexe = sexe;
		this.email = email;
		this.cni = cni;
		this.isactive = isactive;
		this.isdelete = isdelete;
		this.adresse = adresse;
		this.datenaissance = datenaissance;
		this.profile = profile;
	}



	public String getCni() {
		return cni;
	}
	public void setCni(String cni) {
		this.cni = cni;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public Date getDatenaissance() {
		return datenaissance;
	}
	public void setDatenaissance(Date datenaissance) {
		this.datenaissance = datenaissance;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getNbpasswordchanged() {
		return nbpasswordchanged;
	}

	public void setNbpasswordchanged(int nbpasswordchanged) {
		this.nbpasswordchanged = nbpasswordchanged;
	}

	public Date getDateupdate() {
		return dateupdate;
	}

	public void setDateupdate(Date dateupdate) {
		this.dateupdate = dateupdate;
	}
	   

}
