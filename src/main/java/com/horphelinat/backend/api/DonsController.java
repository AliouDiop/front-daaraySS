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
import com.horphelinat.backend.model.Dons;
import com.horphelinat.backend.model.Orphelin;
import com.horphelinat.backend.model.Profile;
import com.horphelinat.backend.repository.ActivitesRepository;
import com.horphelinat.backend.repository.AdoptionRepository;
import com.horphelinat.backend.repository.DonsRepository;
@RestController
@RequestMapping("/api/dons")
@CrossOrigin
public class DonsController {

	@Autowired
	DonsRepository tr;
	
	@Autowired
	ActivitesRepository ar;
	
	
	@PostMapping("/add")
	public Dons AddItem(@RequestBody Dons t) {
        try {
        	
        	t.setDatecreation(new Date());
        	t.setIsdelete(false);
        	tr.save(t);
        	
        	//add activités
        	Activites a= new Activites("Ajout d'un don de : "+t.getDescription()+" venant de "+t.getDonateur().getPrenom()+" "+t.getDonateur().getNom(),"don",new Date(),t.getUsercreateur(),t.getId());
        	ar.save(a);
            return t;
        } catch (Exception e ) {
        	return null;
        }
	}
	
	@GetMapping("/liste")
	public List<Dons> LiseItems() {
		return tr.ListDonsEnCours();
	}
	
	@GetMapping("/list")
	public List<Dons> LiseItem() {
		return tr.findAll();
	}
	
	
	@PostMapping("/update")
	public Dons Updateuser(@RequestBody Dons t) {
        try {
           tr.save(t);
            return t;
        } catch (Exception e ) {
        	return null;
        }
	}
	
	@GetMapping("/delete/{id}")
	public boolean  DelItem(@RequestBody Dons a) {
        try {
        	tr.delete(a);
            return true;
        } catch (Exception e ) {
        	return false ;
        }
	}
	
	@GetMapping("/findById/{id}")
	public Optional<Dons> findById(@PathVariable("id") long id) {
		 return tr.findById(id);    
	}
}