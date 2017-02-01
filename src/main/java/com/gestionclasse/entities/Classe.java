package com.gestionclasse.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CLASSE database table.
 * 
 */
@Entity
@NamedQuery(name="Classe.findAll", query="SELECT c FROM Classe c")
public class Classe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String intitule;


	//bi-directional one-to-one association to Emploi
	@OneToOne(mappedBy="classe")
	private Emploi emploi;

	//bi-directional many-to-one association to Etudiant
	@OneToMany(mappedBy="classe")
	private List<Etudiant> etudiants;

	public Classe() {
	}

	public String getIntitule() {
		return this.intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public Object getEmploi() {
		return this.emploi;
	}


	public void setEmploi(Emploi emploi) {
		this.emploi = emploi;
	}

	public List<Etudiant> getEtudiants() {
		return this.etudiants;
	}

	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}

	public Etudiant addEtudiant(Etudiant etudiant) {
		getEtudiants().add(etudiant);
		etudiant.setClasse(this);

		return etudiant;
	}

	public Etudiant removeEtudiant(Etudiant etudiant) {
		getEtudiants().remove(etudiant);
		etudiant.setClasse(null);

		return etudiant;
	}

}