package com.quest.etna.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.quest.etna.model.JwtUserDetails;
import com.quest.etna.model.User;
import com.quest.etna.repositories.UserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	 @Autowired
	    private UserRepository userRepository;

	@Override
	public JwtUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		return user != null ? new JwtUserDetails(user) : null;
	}

}
