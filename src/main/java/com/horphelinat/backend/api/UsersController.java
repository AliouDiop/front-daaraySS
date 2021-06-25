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

import com.horphelinat.backend.model.Orphelin;
import com.horphelinat.backend.model.Users;
import com.horphelinat.backend.payload.request.LoginRequest;
import com.horphelinat.backend.payload.responce.JwtResponse;
import com.horphelinat.backend.repository.UsersRepository;
import com.horphelinat.backend.security.jwt.JwtUtils;
import com.horphelinat.backend.security.service.UserDetailsImpl;

import javax.validation.Valid;
 
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder; 


@CrossOrigin( maxAge = 3600)
@RestController
@RequestMapping("/api/utilisateur")
public class UsersController {

	@Autowired
	UsersRepository ur;
	
	@Autowired
	AuthenticationManager authenticationManager;


	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;
	 
	
	@PostMapping("/connexion")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		return ResponseEntity.ok(new JwtResponse(jwt,ur.findById(userDetails.getId())));
		
	}
	
	
	@PostMapping("/verificonnexion")
	public Boolean verificonnexion(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		 
		return true;
		
	}
	
	@PostMapping("/logout")
	public Users logout() {
        try {
        	
        	
        } catch (Exception e ) {
        	return null;
        }
        return null;
	}
	
	

	@PostMapping("/add")
	public Users AddItem(@RequestBody Users a) {
        try {
        	a.setPassword(encoder.encode(a.getPassword()));
        	a.setDatecreation(new Date());
        	a.setIsactive(true); 
        	a.setIsdelete(false); 
        	a.setNbpasswordchanged(0);
        	a.setDateupdate(new Date()); 
        	ur.save(a);
        	System.out.println("ajout reussi ");
            return a;
        } catch (Exception e ) {
        	System.out.println(e);
        	System.out.println("erreur ");
        	return null;
        }
	}
	
	@GetMapping("/list")
	public List<Users> LiseItem() {
		return ur.findAll();
	}
	
	
	@GetMapping("/liste/{id}")
	public List<Users> LiseItems(@PathVariable("id") long id) {
		return ur.ListUsersNotDelete(id);
	}
	
	@PostMapping("/update")
	public Users UpdateItem(@RequestBody Users a) {
        try {
        	
            ur.save(a);
            return a;
        } catch (Exception e ) {
        	return null;
        }
	}
	
	@PostMapping("/updatepassword")
	public Users Updatepassword(@RequestBody Users a) {
        try {
        	a.setPassword(encoder.encode(a.getPassword()));
        	a.setDateupdate(new Date());
        	a.setNbpasswordchanged(a.getNbpasswordchanged() + 1);
            ur.save(a);
            return a;
        } catch (Exception e ) {
        	return null;
        }
	}
	
	@GetMapping("/delete/{id}")
	public boolean  DelItem(@RequestBody Users a) {
        try {
        	ur.delete(a);
            return true;
        } catch (Exception e ) {
        	return false ;
        }
	}
	
	@GetMapping("/findById/{id}")
	public Optional<Users> findById(@PathVariable("id") long id) {
		 return ur.findById(id);     
	}
	
	@GetMapping("/findByUsername/{username}")
	public Optional<Users> findByUsername(@PathVariable("username") String username) {
		 return ur.findByUsername(username);     
	}
	
	
	@PostMapping("/verifieLogin/{login}")
	public boolean  verifieLogin(@PathVariable("login") String login) { 
		if(ur.existsByUsername(login)) {
			return true;
		}
		return ur.existsByUsername(login);
	}
	
	@PostMapping("/verifieEmail/{email}")
	public boolean  verifieEmail(@PathVariable("email") String email) { 
		if(ur.existsByEmail(email)) {
			return true;
		}
		return ur.existsByEmail(email);
	}
}