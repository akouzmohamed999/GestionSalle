package com.gestionclasse.models;

import com.gestionclasse.entities.Demande;
import com.gestionclasse.entities.Salle;

public class ProfModel {
	
	private Long id;
	private String idSalle;
	public ProfModel(Long id, String idSalle) {
		super();
		this.id = id;
		this.idSalle = idSalle;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIdSalle() {
		return idSalle;
	}
	public void setIdSalle(String idSalle) {
		this.idSalle = idSalle;
	}
	public ProfModel() {
		super();
	}
	
	 
}
