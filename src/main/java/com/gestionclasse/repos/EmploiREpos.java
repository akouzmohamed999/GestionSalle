package com.gestionclasse.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestionclasse.entities.Classe;
import com.gestionclasse.entities.Emploi;

public interface EmploiREpos extends JpaRepository<Emploi, String>{

	public Emploi findByClasse(Classe classe);
}
