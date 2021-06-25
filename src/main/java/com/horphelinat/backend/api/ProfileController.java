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

import com.horphelinat.backend.model.Profile;
import com.horphelinat.backend.model.Tuteur;
import com.horphelinat.backend.repository.ProfileRepository;
import com.horphelinat.backend.repository.TuteurRepository;

@RestController
@RequestMapping("/api/profil")
@CrossOrigin
public class ProfileController {

	@Autowired
	ProfileRepository tr;
	
	@PostMapping("/add")
	public Profile AddItem(@RequestBody Profile t) {
        try {
        	//t.setDateenvoi(new Date());
        	//t.setCode(encoder.encode(t.getCode()));
        	tr.save(t);
            return t;
        } catch (Exception e ) {
        	return null;
        }
	}
	
	@GetMapping("/liste")
	public List<Profile> LiseItem() {
		return tr.findAll();
	}
	
	@PostMapping("/update")
	public Profile Updateuser(@RequestBody Profile t) {
        try {
           tr.save(t);
            return t;
        } catch (Exception e ) {
        	return null;
        }
	}
	
	@GetMapping("/delete/{id}")
	public boolean  DelItem(@RequestBody Profile a) {
        try {
        	tr.delete(a);
            return true;
        } catch (Exception e ) {
        	return false ;
        }
	}
	
	@GetMapping("/findById/{id}")
	public Optional<Profile> findById(@PathVariable("id") long id) {
		 return tr.findById(id);    
	}
	
}