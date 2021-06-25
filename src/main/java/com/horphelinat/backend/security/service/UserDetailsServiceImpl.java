package com.horphelinat.backend.security.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.horphelinat.backend.model.Users;
import com.horphelinat.backend.repository.UsersRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UsersRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Users user = userRepository.findByUsername(login)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + login));

		return UserDetailsImpl.build(user);
	}
}