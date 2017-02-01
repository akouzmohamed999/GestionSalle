package com.gestionclasse.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestionclasse.entities.Professeur;

public interface ProfesseurRepos extends JpaRepository<Professeur, String>{

}
