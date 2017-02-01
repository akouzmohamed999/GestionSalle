package com.gestionclasse.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PERSONNE database table.
 * 
 */
@Entity
@NamedQuery(name="Personne.findAll", query="SELECT p FROM Personne p")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Personne implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String cin;

	private String nom;

	private String prenom;

	public Personne() {
	}
	

	public Personne(String cin, String nom, String prenom) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
	}


	public String getCin() {
		return this.cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}