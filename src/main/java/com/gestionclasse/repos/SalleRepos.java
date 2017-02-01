package com.gestionclasse.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestionclasse.entities.Salle;

public interface SalleRepos extends JpaRepository<Salle, String>{

	public Salle findById(String id);
}
