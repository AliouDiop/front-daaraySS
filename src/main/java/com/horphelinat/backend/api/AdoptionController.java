package com.horphelinat.backend.api;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.horphelinat.backend.model.Activites;
import com.horphelinat.backend.model.Adoption;
import com.horphelinat.backend.model.Orphelin;
import com.horphelinat.backend.repository.ActivitesRepository;
import com.horphelinat.backend.repository.AdoptionRepository;
@RestController
@RequestMapping("/api/adoption")
@CrossOrigin
public class AdoptionController {

	@Autowired
	AdoptionRepository tr;
	
	@Autowired
	ActivitesRepository ar;
	
	@PostMapping("/add")
	public Adoption AddItem(@RequestBody Adoption t) {
        try {
        	t.setDatecreation(new Date());
        	t.setIsdelete(false);
        	tr.save(t);
        	
        	//add activités
        	Activites a= new Activites("Adoption de l'orphelin : "+t.getOrphelin().getId()+"- "+t.getOrphelin().getPrenom()+" "+t.getOrphelin().getNom()+" par "+t.getTuteur().getPrenom()+" "+t.getTuteur().getNom(),"adoption",new Date(),t.getUsercreateur(),t.getId());
        	ar.save(a);
            return t;
        } catch (Exception e ) {
        	return null;
        }
	}
	
	@GetMapping("/liste")
	public List<Adoption> LiseItems() {
		return tr.ListAdoptionEnCours();
	}
	
	@GetMapping("/list")
	public List<Adoption> LiseItem() {
		return tr.findAll();
	}
	
	@PostMapping("/update")
	public Adoption Updateuser(@RequestBody Adoption t) {
        try {
           tr.save(t);
            return t;
        } catch (Exception e ) {
        	return null;
        }
	}
	
	@GetMapping("/delete/{id}")
	public boolean  DelItem(@RequestBody Adoption a) {
        try {
        	tr.delete(a);
            return true;
        } catch (Exception e ) {
        	return false ;
        }
	}
	
	@GetMapping("/findById/{id}")
	public Optional<Adoption> findById(@PathVariable("id") long id) {
		 return tr.findById(id);    
	}
}