package com.gestionclasse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestionclasse.entities.Role;
import com.gestionclasse.repos.MembreRepository;

@Service
@Qualifier("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{
	
	
	@Autowired
	MembreRepository membreRepository;
	
	//Recupération de l'user
	@Transactional(readOnly=true)
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		com.gestionclasse.entities.Membre membre = membreRepository.findByEmail(email);
		List<GrantedAuthority> authorities = buildUserAuthority(membre, membre.getRoles());
		return buildUserForAuthentication(membre, authorities);
	}
	
		//Création de USER_Details apartir de l'user qu'on a dans la BD
	  private User buildUserForAuthentication(com.gestionclasse.entities.Membre membre,List<GrantedAuthority> authorities) {
        return new User(membre.getEmail(), membre.getPassword(), authorities);
    }

	  //Recupération des Roles de l'utilisateur
    private List<GrantedAuthority> buildUserAuthority(com.gestionclasse.entities.Membre membre, Collection<Role> userRoles) {

        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

        // Build user's authorities
        for (Role userRole : userRoles) {
            setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
            System.out.println(" =========>"+userRole.getRole());
        }
        if (setAuths.isEmpty()){
        	setAuths.add(new SimpleGrantedAuthority(membre.getClass().getSimpleName()));
        	//System.out.println(" ******"+setAuths.toString());
        };
        
        return new ArrayList<GrantedAuthority>(setAuths);
    }
	
}
