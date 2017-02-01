package com.gestionclasse.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the SALLE database table.
 * 
 */
@Entity
@NamedQuery(name="Salle.findAll", query="SELECT s FROM Salle s")
public class Salle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String departement;

	@Column(name="\"TYPE\"")
	private String type;

	//bi-directional many-to-one association to Creneau
	@OneToMany(mappedBy="salle")
	private List<Creneau> creneaus;

	public Salle() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDepartement() {
		return this.departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Creneau> getCreneaus() {
		return this.creneaus;
	}

	public void setCreneaus(List<Creneau> creneaus) {
		this.creneaus = creneaus;
	}

	public Creneau addCreneaus(Creneau creneaus) {
		getCreneaus().add(creneaus);
		creneaus.setSalle(this);

		return creneaus;
	}

	public Creneau removeCreneaus(Creneau creneaus) {
		getCreneaus().remove(creneaus);
		creneaus.setSalle(null);

		return creneaus;
	}

}