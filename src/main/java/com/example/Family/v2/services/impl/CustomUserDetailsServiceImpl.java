package com.example.Family.v2.services.impl;

import com.example.Family.v2.repositories.ClientRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {

	private final ClientRepository clientRepository;

	public CustomUserDetailsServiceImpl(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return clientRepository.findByName(username)
							   .orElseThrow(() -> new UsernameNotFoundException(String.format("No user found with username '%s'.", username)));
	}
}
