package com.gestionclasse.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PROFESSEUR database table.
 * 
 */
@Entity
@NamedQuery(name="Professeur.findAll", query="SELECT p FROM Professeur p")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Professeur extends Membre implements Serializable {

	public Professeur(String cin, String nom, String prenom, String email) {
		super(cin, nom, prenom, email);
		// TODO Auto-generated constructor stub
	}

	
	/*private static final long serialVersionUID = 1L;*/

	/*@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
	private Long IdProf;

	/*private String email;

	private String nom;

	private String password;

	private String prenom;

	//bi-directional many-to-one association to Demande
	@OneToMany(mappedBy="professeur")
	private List<Demande> demandes;

	//bi-directional many-to-one association to Creneau
	@OneToMany(mappedBy="professeur")
	private List<Creneau> creneaus;

	*/
	public Professeur() {
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
		demande.setProfesseur(this);

		return demande;
	}

	public Demande removeDemande(Demande demande) {
		getDemandes().remove(demande);
		demande.setProfesseur(null);

		return demande;
	}

	public List<Creneau> getCreneaus() {
		return this.creneaus;
	}

	public void setCreneaus(List<Creneau> creneaus) {
		this.creneaus = creneaus;
	}

	public Creneau addCreneaus(Creneau creneaus) {
		getCreneaus().add(creneaus);
		creneaus.setProfesseur(this);

		return creneaus;
	}

	public Creneau removeCreneaus(Creneau creneaus) {
		getCreneaus().remove(creneaus);
		creneaus.setProfesseur(null);

		return creneaus;
	}*/

}