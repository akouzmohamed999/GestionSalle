package com.gestionclasse.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gestionclasse.entities.Demande;

public interface DemandeRepos extends JpaRepository<Demande, Long>{

	public Demande findByNumdemande(Long id);
	
	@Query("SELECT d from Demande d where d.etat='APPROVE'")
	public List<Demande> findDemandeApprove();
}
