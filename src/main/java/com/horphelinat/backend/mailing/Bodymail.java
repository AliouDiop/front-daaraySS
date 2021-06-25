package com.horphelinat.backend.mailing;

import java.io.Serializable;

public class Bodymail implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String destinataire;
	    
	private String objet;
	  
	private String message;

	public Bodymail(String destinataire, String objet, String message) {
		super();
		this.destinataire = destinataire;
		this.objet = objet;
		this.message = message;
	}

	public Bodymail() {
		super();
	}

	public String getDestinataire() {
		return destinataire;
	}

	public void setDestinataire(String destinataire) {
		this.destinataire = destinataire;
	}

	public String getObjet() {
		return objet;
	}

	public void setObjet(String objet) {
		this.objet = objet;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	    
	

}
