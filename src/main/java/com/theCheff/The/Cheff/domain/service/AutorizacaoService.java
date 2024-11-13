package com.theCheff.The.Cheff.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.theCheff.The.Cheff.domain.model.repository.UsuariosRepository;

@Service
public class AutorizacaoService implements UserDetailsService {

	@Autowired
	UsuariosRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		return repository.findByEmail(username).orElseThrow(() -> new RuntimeException("No data!"));
		 return repository.findUserDetailsByLogin(username);
	}

}
