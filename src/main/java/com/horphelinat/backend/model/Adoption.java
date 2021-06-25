package com.horphelinat.backend.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "adoption")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id",scope = Long.class)
public class Adoption implements Serializable {

	public Adoption() {
		super();
	}



	public Adoption(long id, Date date, Date datecreation, Orphelin orphelin, Tuteur tuteur, Boolean isdelete,
			Users usercreateur, String infosup) {
		super();
		this.id = id;
		this.date = date;
		this.datecreation = datecreation;
		this.orphelin = orphelin;
		this.tuteur = tuteur;
		this.isdelete = isdelete;
		this.usercreateur = usercreateur;
		this.infosup = infosup;
	}



	public Users getUsercreateur() {
		return usercreateur;
	}

	public void setUsercreateur(Users usercreateur) {
		this.usercreateur = usercreateur;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Orphelin getOrphelin() {
		return orphelin;
	}

	public void setOrphelin(Orphelin orphelin) {
		this.orphelin = orphelin;
	}

	public Tuteur getTuteur() {
		return tuteur;
	}

	public void setTuteur(Tuteur tuteur) {
		this.tuteur = tuteur;
	}


	public String getInfosup() {
		return infosup;
	}

	public void setInfosup(String infosup) {
		this.infosup = infosup;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private long id;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "datecreation")
	private Date datecreation;
	
	@JoinColumn(name = "orphelin", referencedColumnName = "id")
	@ManyToOne
	private Orphelin orphelin;
	
	@JoinColumn(name = "tuteur", referencedColumnName = "id")
	@ManyToOne
	private Tuteur tuteur;
	 public Boolean getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(Boolean isdelete) {
		this.isdelete = isdelete;
	}

	public Date getDatecreation() {
		return datecreation;
	}


	public void setDatecreation(Date datecreation) {
		this.datecreation = datecreation;
	}

	@Column(name = "isdelete")
	   private Boolean isdelete;
	@JoinColumn(name = "usercreateur", referencedColumnName = "id")
	@ManyToOne
	private Users usercreateur;
	
	@Column(name = "infosup")
	private String infosup;
}
