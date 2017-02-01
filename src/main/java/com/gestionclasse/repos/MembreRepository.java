package com.gestionclasse.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestionclasse.entities.Membre;

public interface MembreRepository extends JpaRepository<Membre, String>{

	public Membre findByEmail(String email);
}
