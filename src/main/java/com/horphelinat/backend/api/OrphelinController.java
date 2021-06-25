package com.horphelinat.backend.api;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.horphelinat.backend.repository.DonsRepository;
import com.horphelinat.backend.repository.OrphelinRepository;

@RestController
@RequestMapping("/api/orphelin")
@CrossOrigin
public class OrphelinController {

	@Autowired
	OrphelinRepository tr;
	
	@Autowired
	ActivitesRepository ar;
	
	@PostMapping("/add")
	public Orphelin AddItem(@RequestBody Orphelin t) {
        try {
        	t.setDateentree(new Date());
        	t.setIsactive(true);
        //	t.setPhoto("gfdhhdf");
        	tr.save(t);
        	
        	//add activités
        	Activites a= new Activites("Inscription de l'orphelin : "+t.getId()+"- "+t.getPrenom()+" "+t.getNom(),"orphelin",new Date(),t.getUsercreateur(),t.getId());
        	ar.save(a);
        	
            return t;
        } catch (Exception e ) {
        	return null;
        }
	}
	
	@GetMapping("/list")
	public List<Orphelin> LiseItem() {
		return tr.findAll();
	}
	
	@GetMapping("/liste")
	public List<Orphelin> LiseItems() {
		return tr.ListOrphelinActive();
	}
	
	@PostMapping("/update")
	public Orphelin Updateuser(@RequestBody Orphelin t) {
        try {
           tr.save(t);
           
           if(t.getIsactive()==false) {
        	   //add activités
              	Activites a= new Activites("Transfert de l'orphelin : "+t.getId()+"- "+t.getPrenom()+" "+t.getNom(),"orphelin",new Date(),t.getUsercreateur(),t.getId());
              	ar.save(a);
           }
           else {
        	   //add activités
              	Activites a= new Activites("Modification de l'orphelin : "+t.getId()+"- "+t.getPrenom()+" "+t.getNom(),"orphelin",new Date(),t.getUsercreateur(),t.getId());
              	ar.save(a);
           }
       	
            return t;
        } catch (Exception e ) {
        	return null;
        }
	}
	
	@GetMapping("/delete/{id}")
	public boolean  DelItem(@RequestBody Orphelin t) {
        try {
        	tr.delete(t);
        	
            return true;
        } catch (Exception e ) {
        	return false ;
        }
	}
	
	@GetMapping("/findById/{id}")
	public Optional<Orphelin> findById(@PathVariable("id") long id) {
		 return tr.findById(id);    
	}
}