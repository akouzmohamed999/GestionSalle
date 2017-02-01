package com.gestionclasse;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.gestionclasse.entities.Classe;
import com.gestionclasse.entities.Creneau;
import com.gestionclasse.entities.Demande;
import com.gestionclasse.entities.Emploi;
import com.gestionclasse.entities.Professeur;
import com.gestionclasse.entities.Salle;
import com.gestionclasse.models.ProfModel;
import com.gestionclasse.repos.ClasseRepos;
import com.gestionclasse.repos.CreneauRepos;
import com.gestionclasse.repos.DemandeRepos;
import com.gestionclasse.repos.EmploiREpos;
import com.gestionclasse.repos.ProfesseurRepos;
import com.gestionclasse.repos.ResponsableRepos;
import com.gestionclasse.repos.SalleRepos;
import com.gestionclasse.repos.SecretaireRepos;








/*@Configuration
public class WebController extends WebMvcConfigurerAdapter{
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		
		registry.addViewController("/home").setViewName("index");
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/logout").setViewName("logout");
		registry.addRedirectViewController("/", "/home");
	}
}*/

@Controller
public class WebController {
		
	@Autowired
	DemandeRepos demanderepo;
	
	@Autowired
	ProfesseurRepos profRepo;
	
	@Autowired
	CreneauRepos creneauRepo;
	
	@Autowired
	SalleRepos salleRepos;
	
	@Autowired
	SecretaireRepos secrtRepos;
	
	@Autowired
	ResponsableRepos respoRepos;
	
	@Autowired
	ClasseRepos classeRepos;
	
	@Autowired
	EmploiREpos emploirepos;
	@RequestMapping(value="/home")
	public String indexAction(Model model){
		model.addAttribute("classe",new Classe());
		model.addAttribute("classes",classeRepos.findAll());
		Classe cc = new Classe();
		Emploi ee = new Emploi();
			ee.setLien("Lien Vers Emploi");
			ee.setClasse(cc);
		cc.setEmploi(ee);
		model.addAttribute("resultat",ee);
		return "index";
	}
	
	@RequestMapping(value="/ChercherEmploi")
	public String indexAction(@ModelAttribute Classe classe,BindingResult bb,Model model){
		model.addAttribute("classes",classeRepos.findAll());
		Classe cc = classeRepos.findByIntitule(classe.getIntitule());
		Emploi em = emploirepos.findByClasse(cc);
		model.addAttribute("resultat",em);
		return "index";
	}
	
	
	@RequestMapping(value="/ProfView")
	public String profAction(Model model){
		
		model.addAttribute("demande",new Demande());
		model.addAttribute("demandes",demanderepo.findAll());
		
		return "Profview";
	}
	
	@RequestMapping(value="/ajouterDemande")
	public String ajouterDemande(@ModelAttribute Demande demande,BindingResult bb){
			Demande dd = new Demande();
			dd.setDatesouhaite(demande.getDatesouhaite());
			//System.out.println(demande.getDatesouhaite());
			dd.setEtat("En ATTENTE");
			dd.setTypesalle(demande.getTypesalle());
			//System.out.println(demande.getTypesalle());
			dd.setProfesseur((Professeur) profRepo.findAll().get(0));
			demanderepo.save(dd);
			return "redirect:/ProfView";
	}
	
	@RequestMapping(value="/SecrView")
	public String secrAction(Model model){

		model.addAttribute("demandes",demanderepo.findAll());

		return "SecrView";
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/home";
	}
	
	@RequestMapping(value="/approverDemande/{id}")
	public String apprverAction(@PathVariable Long id){
		Demande dd = demanderepo.findByNumdemande(id);
		dd.setEtat("APPROVE");
		dd.setSecretaire(secrtRepos.findAll().get(0));
		demanderepo.save(dd);
		return "redirect:/SecrView";
	}
	
	
	@RequestMapping(value="/SupprimerDemande/{id}")
	public String supprimerAction(@PathVariable Long id){
		Demande dd = demanderepo.findByNumdemande(id);
		demanderepo.delete(dd);
		return "redirect:/SecrView";
	}
	
	@RequestMapping(value="/Respview")
	public String respAction(Model model){
		model.addAttribute("demandes",demanderepo.findDemandeApprove());
		model.addAttribute("creneaux",creneauRepo.findAll());
		model.addAttribute("salles",salleRepos.findAll());
		model.addAttribute("profmodel",new ProfModel());
		
		return "RespView";
		}
	
	
	@RequestMapping(value="/ConfirmerDemande")
	public String ConfirmerAction(@ModelAttribute ProfModel profmodel, BindingResult bb){
		Demande dd = demanderepo.findByNumdemande(profmodel.getId());
		System.out.println(profmodel.getId()+"deeeeeeeeee"+profmodel.getIdSalle());
		dd.setEtat("Confirmee");
		Creneau cc = new Creneau();
		cc.setDatedebut(dd.getDatesouhaite());
		 Calendar calendar = Calendar.getInstance();
		    calendar.setTime(dd.getDatesouhaite());
		    calendar.add(Calendar.HOUR, 3);
		    Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());
	
		cc.setDatefin(timestamp);
		Salle ss = salleRepos.findById(profmodel.getIdSalle());
		
		cc.setSalle(ss);
		cc.setProfesseur(dd.getProfesseur());
		dd.setResponsable(respoRepos.findAll().get(0));
		//System.out.println("iddddddddd"+idSalle+"SALLLLLLLLE"+ss+"proooof"+dd.getProfesseur());
		demanderepo.save(dd);
		creneauRepo.save(cc);
		return "redirect:/Respview";
	}
	
	@RequestMapping(value="/RejeterDemande/{id}")
	public String RejecterAction(@PathVariable Long id){
		Demande dd = demanderepo.findByNumdemande(id);
		dd.setEtat("Rejetee");
		dd.setResponsable(respoRepos.findAll().get(0));
		demanderepo.save(dd);
		return "redirect:/Respview";
	}
}
