package com.gestionclasse.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the EMPLOI database table.
 * 
 */
@Entity
@NamedQuery(name="Emploi.findAll", query="SELECT e FROM Emploi e")
public class Emploi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String lien;
	//bi-directional one-to-one association to Classe
	@OneToOne
	private Classe classe;

	public Emploi() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Classe getClasse() {
		return this.classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public String getLien() {
		return lien;
	}

	public void setLien(String lien) {
		this.lien = lien;
	}

}