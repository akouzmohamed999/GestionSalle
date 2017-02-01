package com.gestionclasse;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.gestionclasse.entities.Classe;
import com.gestionclasse.entities.Emploi;
import com.gestionclasse.entities.Membre;
import com.gestionclasse.entities.Professeur;
import com.gestionclasse.entities.Responsable;
import com.gestionclasse.entities.Secretaire;
import com.gestionclasse.repos.ClasseRepos;
import com.gestionclasse.repos.EmploiREpos;
import com.gestionclasse.repos.MembreRepository;

@SpringBootApplication
public class GestionClasseProjectApplication {

	public static void main(String[] args) {
		ApplicationContext ctx =  SpringApplication.run(GestionClasseProjectApplication.class, args);
		/*Membre m1 = new Membre("J488475", "Akouz", "mohamed", "akouz@gmail.com");
		
		Professeur prof = new Professeur("J488475", "Akouz", "mohamed", "akouz@gmail.com");
		
		BCryptPasswordEncoder bcr = new BCryptPasswordEncoder();
		m1.setPassword(bcr.encode("akouz"));
		prof.setPassword(bcr.encode("akouz"));
		ctx.getBean(MembreRepository.class).save(m1);
		ctx.getBean(MembreRepository.class).save(prof);
		Membre m2 = new Membre("J4774854", "Fatima", "alami", "akouz@gmail.com");
		m2.setPassword(bcr.encode("alami"));
		Secretaire secretaire = new Secretaire("J4774854", "Fatima", "alami", "alami@gmail.com");
		
		secretaire.setPassword(bcr.encode("alami"));
		ctx.getBean(MembreRepository.class).save(m2);
		ctx.getBean(MembreRepository.class).save(secretaire);
		
		Membre m3 = new Membre("J8547451", "Rachid", "raki", "raki@gmail.com");
		m3.setPassword(bcr.encode("raki"));
		Responsable responsable = new Responsable("J8547451", "Rachid", "raki", "raki@gmail.com");
		//BCryptPasswordEncoder bcr = new BCryptPasswordEncoder();
		//MembreRepository mm = ctx.getBean(MembreRepository.class);
		responsable.setPassword(bcr.encode("raki"));
		ctx.getBean(MembreRepository.class).save(m3);
		ctx.getBean(MembreRepository.class).save(responsable);*/
		
		/*Emploi emp1 = new Emploi();
		emp1.setId("ISIM12017");
		emp1.setLien("file:///E:/emlpoiISIM1.jpg");
		
		Emploi emp2 = new Emploi();
			emp2.setId("ISIM22017");
			emp2.setLien("file:///E:/emploiISIM2.jpg");
		
		Classe cl1 = new Classe();
		cl1.setIntitule("Master ISI M1");
		cl1.setEmploi(emp1);
		
		Classe cl2 = new Classe();
			cl2.setIntitule("Master ISI M2");
			cl2.setEmploi(emp2);
			
			emp1.setClasse(cl1);
			emp2.setClasse(cl2);
			
			ctx.getBean(ClasseRepos.class).save(cl1);
			ctx.getBean(ClasseRepos.class).save(cl2);
			ctx.getBean(EmploiREpos.class).save(emp1);
			ctx.getBean(EmploiREpos.class).save(emp2);*/
			
	}
}
