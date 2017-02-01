package com.gestionclasse.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ADMINISTRATEUR database table.
 * 
 */
@Entity
@NamedQuery(name="Administrateur.findAll", query="SELECT a FROM Administrateur a")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Administrateur extends Membre implements Serializable {

	public Administrateur(String cin, String nom, String prenom, String email) {
		super(cin, nom, prenom, email);
		// TODO Auto-generated constructor stub
	}

	

	
	/*private static final long serialVersionUID = 1L;*/

	/*@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
	private String cin;*/

	/*private String email;

	private String nom;

	private String password;

	private String prenom;

	*/
	public Administrateur() {
	}
	
	
	
	/*public String getCin() {
		return this.cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}*/

}