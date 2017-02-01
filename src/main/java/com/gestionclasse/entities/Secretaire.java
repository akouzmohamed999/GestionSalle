package com.gestionclasse.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the SECRETAIRE database table.
 * 
 */
@Entity
@NamedQuery(name="Secretaire.findAll", query="SELECT s FROM Secretaire s")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Secretaire extends Membre implements Serializable {

	public Secretaire(String cin, String nom, String prenom, String email) {
		super(cin, nom, prenom, email);
		// TODO Auto-generated constructor stub
	}

	
/*	private static final long serialVersionUID = 1L;*/

	/*@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
	private Long idSecretaire;

	/*private String email;

	private String nom;

	private String password;

	private String prenom;

	//bi-directional many-to-one association to Demande
	@OneToMany(mappedBy="secretaire")
	private List<Demande> demandes;
	*/
	
	public Secretaire() {
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
	}

	public List<Demande> getDemandes() {
		return this.demandes;
	}

	public void setDemandes(List<Demande> demandes) {
		this.demandes = demandes;
	}

	public Demande addDemande(Demande demande) {
		getDemandes().add(demande);
		demande.setSecretaire(this);

		return demande;
	}

	public Demande removeDemande(Demande demande) {
		getDemandes().remove(demande);
		demande.setSecretaire(null);

		return demande;
	}*/

}