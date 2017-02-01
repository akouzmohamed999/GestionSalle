package com.gestionclasse.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the MEMBRE database table.
 * 
 */
@Entity
@NamedQuery(name="Membre.findAll", query="SELECT m FROM Membre m")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Membre extends Personne implements Serializable {
	/*private static final long serialVersionUID = 1L;

	@Id
	private String cin;*/
	
	//@Id
	private String email;

	/*private String nom;*/
	
	private String password;

	/*private String prenom;*/

	//bi-directional many-to-many association to Role
	@ManyToMany
	@JoinTable(name="USERS_ROLES")
	private List<Role> roles;

	public Membre() {
	}

	/*public String getCin() {
		return this.cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}*/

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
	}*/

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/*public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}*/

	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Membre(String cin, String nom, String prenom, String email) {
		super(cin, nom, prenom);
		this.email=email;
		// TODO Auto-generated constructor stub
	}

	

}