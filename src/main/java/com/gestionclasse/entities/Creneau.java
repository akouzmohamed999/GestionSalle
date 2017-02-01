package com.gestionclasse.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;


/**
 * The persistent class for the CRENEAU database table.
 * 
 */
@Entity
@NamedQuery(name="Creneau.findAll", query="SELECT c FROM Creneau c")
public class Creneau implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
	private long id;

	private Timestamp datedebut;

	private Timestamp datefin;

	//bi-directional many-to-one association to Salle
	@ManyToOne
	@JoinColumn(name="SALLE")
	private Salle salle;

	//bi-directional many-to-one association to Professeur
	@ManyToOne
	@JoinColumn(name="PROFESSEUR")
	private Professeur professeur;

	public Creneau() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	

	public Timestamp getDatedebut() {
		return datedebut;
	}

	public void setDatedebut(Timestamp datedebut) {
		this.datedebut = datedebut;
	}

	public Timestamp getDatefin() {
		return datefin;
	}

	public void setDatefin(Timestamp datefin) {
		this.datefin = datefin;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public Professeur getProfesseur() {
		return professeur;
	}

	public void setProfesseur(Professeur professeur) {
		this.professeur = professeur;
	}


}