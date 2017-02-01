package com.gestionclasse.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestionclasse.entities.Classe;

public interface ClasseRepos extends JpaRepository<Classe, String>{

	public Classe findByIntitule(String intitule);
}
