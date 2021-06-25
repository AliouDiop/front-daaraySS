package com.horphelinat.backend;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.horphelinat.backend.model.Profile;
import com.horphelinat.backend.model.Users;
import com.horphelinat.backend.repository.ProfileRepository;
import com.horphelinat.backend.repository.UsersRepository;


@SpringBootApplication
public class BackendGesHorphelinatApplication extends SpringBootServletInitializer implements  CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BackendGesHorphelinatApplication.class, args);
	}
	
	@Autowired
	ProfileRepository pr;
	
	@Autowired
	PasswordEncoder encoder;

	@Autowired
	UsersRepository agr;
	

	@Override
	public void run(String... args) throws Exception {
		//creation des profile
		if(pr.findAll().size() == 0) {
			Profile p1 = new Profile("Administrateur",new Date());
			Profile p2 = new Profile("Modérateur",new Date());
			pr.save(p1);
			pr.save(p2);
		}
		
		//creation d'un admin
		if(agr.findAll().size() == 0) {
			Users a = new Users();
			a.setAdresse("nord foire");
			a.setCni("123456789");
			a.setDatecreation(new Date());
			a.setDatenaissance(new Date());
			a.setEmail("badoujop6@gmail.com");
			a.setIsactive(true);
			a.setIsdelete(false);
			a.setProfile("Administrateur");
			a.setNbpasswordchanged(0);
			a.setNom("Admin");
			a.setPassword(encoder.encode("passer"));
			a.setPrenom("Admin");
			a.setSexe("Masculin");
			a.setTelephone("778538538");
			a.setUsername("admin");
			a.setDateupdate(new Date());
			agr.save(a);
		}
		
	}
}
