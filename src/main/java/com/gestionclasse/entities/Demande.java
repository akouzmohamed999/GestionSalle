package com.gestionclasse.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;


/**
 * The persistent class for the DEMANDE database table.
 * 
 */
@Entity
@NamedQuery(name="Demande.findAll", query="SELECT d FROM Demande d")
public class Demande implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
	private long numdemande;

	private Timestamp datesouhaite;

	private String etat;

	private String typesalle;

	//bi-directional many-to-one association to Professeur
	@ManyToOne
	@JoinColumn(name="PROFESSEUR")
	private Professeur professeur;

	//bi-directional many-to-one association to Secretaire
	@ManyToOne
	@JoinColumn(name="SECRETAIRE")
	private Secretaire secretaire;

	//bi-directional many-to-one association to Responsable
	@ManyToOne
	@JoinColumn(name="RESPONSABLE")
	private Responsable responsable;

	public Demande() {
	}

	public long getNumdemande() {
		return this.numdemande;
	}

	public void setNumdemande(long numdemande) {
		this.numdemande = numdemande;
	}


	public Timestamp getDatesouhaite() {
		return datesouhaite;
	}

	public void setDatesouhaite(Timestamp datesouhaite) {
		this.datesouhaite = datesouhaite;
	}

	public String getEtat() {
		return this.etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public String getTypesalle() {
		return this.typesalle;
	}

	public void setTypesalle(String typesalle) {
		this.typesalle = typesalle;
	}

	public Professeur getProfesseur() {
		return professeur;
	}

	public void setProfesseur(Professeur professeur) {
		this.professeur = professeur;
	}

	public Secretaire getSecretaire() {
		return secretaire;
	}

	public void setSecretaire(Secretaire secretaire) {
		this.secretaire = secretaire;
	}

	public Responsable getResponsable() {
		return responsable;
	}

	public void setResponsable(Responsable responsable) {
		this.responsable = responsable;
	}



}