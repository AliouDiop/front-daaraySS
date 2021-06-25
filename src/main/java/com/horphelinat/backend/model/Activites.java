package com.horphelinat.backend.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators; 

@Entity
@Table(name = "activites")
public class Activites implements Serializable {

	public Activites() {
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
	@Column(name = "description")
	private String description;	
	@Column(name = "type")
	private String type;	
	@Column(name = "date")
    private Date date;
	@JoinColumn(name = "utilisateur", referencedColumnName = "id")
	@ManyToOne
	private Users utilisateur;
	@Column(name = "idActImp")
	private long idActImp;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public long getIdActImp() {
		return idActImp;
	}
	public void setIdActImp(long idActImp) {
		this.idActImp = idActImp;
	}
	public Activites(String description, String type, Date date, Users utilisateur, long idActImp) {
		super();
		this.description = description;
		this.type = type;
		this.date = date;
		this.utilisateur = utilisateur;
		this.idActImp = idActImp;
	}
	public Users getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Users utilisateur) {
		this.utilisateur = utilisateur;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
	
