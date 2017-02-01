package com.gestionclasse;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.gestionclasse.entities.Demande;
import com.gestionclasse.entities.Professeur;
import com.gestionclasse.models.ProfModel;
import com.gestionclasse.repos.DemandeRepos;
import com.gestionclasse.repos.ProfesseurRepos;


@Configuration
public class WebDefaultController extends WebMvcConfigurerAdapter{
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		
		//registry.addViewController("/home").setViewName("index");
		registry.addViewController("/login").setViewName("login");
		//registry.addViewController("/logout").setViewName("logout");
		//registry.addRedirectViewController("/", "/home");
	}
}
