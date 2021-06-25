package com.horphelinat.backend.api;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.horphelinat.backend.model.Activites;
import com.horphelinat.backend.repository.ActivitesRepository;


@RestController
@RequestMapping("/api/activites")
@CrossOrigin
public class ActivitesController {

	@Autowired
	ActivitesRepository ar;
	
	@PostMapping("/add")
	public Activites AddItem(@RequestBody Activites a) {
        try {
        	a.setDate(new Date());
        	ar.save(a);
            return a;
        } catch (Exception e ) {
        	return null;
        }
	}
	
	@GetMapping("/liste")
	public List<Activites> LiseItem() {
		return ar.HistoriqueActivtes();
	}
	
	@PostMapping("/update")
	public Activites UpdateItem(@RequestBody Activites a) {
        try {
            ar.save(a);
            return a;
        } catch (Exception e ) {
        	return null;
        }
	}
	
	@GetMapping("/delete/{id}")
	public boolean  DelItem(@RequestBody Activites a) {
        try {
        	ar.delete(a);
            return true;
        } catch (Exception e ) {
        	return false ;
        }
	}
	
	@GetMapping("/findById/{id}")
	public Optional<Activites> findById(@PathVariable("id") long id) {
		 return ar.findById(id);
	}
	
	@GetMapping("/listeByDate")
	public List<Activites> ListeByUserid() {
		return ar.findAllActivitesDESC();
	}
	
}
