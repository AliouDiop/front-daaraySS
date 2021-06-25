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
@Table(name = "dons")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id",scope = Long.class)
public class Dons implements Serializable {

	public Dons() {
		super();
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
	
	@JoinColumn(name = "donateur", referencedColumnName = "id")
	@ManyToOne
	private Donateur donateur;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "isdelete")
	 private Boolean isdelete;
	
	@JoinColumn(name = "usercreateur", referencedColumnName = "id")
	@ManyToOne
	private Users usercreateur;

	

	public Dons(long id, Date date, Date datecreation, Donateur donateur, String description, Boolean isdelete,
			Users usercreateur) {
		super();
		this.id = id;
		this.date = date;
		this.datecreation = datecreation;
		this.donateur = donateur;
		this.description = description;
		this.isdelete = isdelete;
		this.usercreateur = usercreateur;
	}

	public Date getDatecreation() {
		return datecreation;
	}

	public void setDatecreation(Date datecreation) {
		this.datecreation = datecreation;
	}

	public Boolean getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(Boolean isdelete) {
		this.isdelete = isdelete;
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

	public Donateur getDonateur() {
		return donateur;
	}

	public void setDonateur(Donateur donateur) {
		this.donateur = donateur;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
}
