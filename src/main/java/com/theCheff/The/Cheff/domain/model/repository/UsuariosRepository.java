package com.theCheff.The.Cheff.domain.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.theCheff.The.Cheff.domain.model.entity.Usuarios;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {

//    Optional<Usuarios> findByEmail(String email);
	
//	 UserDetails findByLogin(String login);
	 
	 UserDetails findUserDetailsByLogin(String login);

}
