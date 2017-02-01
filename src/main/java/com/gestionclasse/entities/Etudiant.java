package com.gestionclasse.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ETUDIANT database table.
 * 
 */
@Entity
@NamedQuery(name="Etudiant.findAll", query="SELECT e FROM Etudiant e")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Etudiant extends Personne implements Serializable {
	/*private static final long serialVersionUID = 1L;

	@Id
	private String cin;*/
	
	//@Id
	private String cne;

	private String email;

	/*private String nom;

	private String prenom;*/

	//bi-directional many-to-one association to Classe
	@ManyToOne
	@JoinColumn(name="CLASSE")
	private Classe classe;

	public Etudiant() {
	}

	
	/*public String getCin() {
		return this.cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}*/

	public Etudiant(String cin, String nom, String prenom, String cne) {
		super(cin, nom, prenom);
		this.cne=cne;
		// TODO Auto-generated constructor stub
	}


	public String getCne() {
		return this.cne;
	}

	public void setCne(String cne) {
		this.cne = cne;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/*public String getNom() {
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
	}*/

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}



}