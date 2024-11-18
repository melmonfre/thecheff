package com.theCheff.The.Cheff.domain.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.theCheff.The.Cheff.domain.dtos.AutenticacaoDTO;
import com.theCheff.The.Cheff.domain.dtos.LoginResponseDTO;
import com.theCheff.The.Cheff.domain.dtos.RegistroDTO;
import com.theCheff.The.Cheff.domain.model.entity.Usuarios;
import com.theCheff.The.Cheff.domain.model.repository.UsuariosRepository;
import com.theCheff.The.Cheff.infra.security.TokenService;
import com.theCheff.The.Cheff.util.EnvelopeService;

@Service
public class AutorizacaoService implements UserDetailsService {

	@Autowired
	UsuariosRepository repository;

	@Autowired
	TokenService tokenService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return repository.findUserDetailsByLogin(username);
	}

	public EnvelopeService<ResponseEntity> registrar(RegistroDTO dto) {
		if (this.repository.findUserDetailsByLogin(dto.login()) != null) {
			return new EnvelopeService<>(null, false, "Usuario não encontrado");
		} else {

			String encryptedPassword = new BCryptPasswordEncoder().encode(dto.senha());
			Usuarios newUser = new Usuarios(dto.login(), encryptedPassword, dto.nomeDaEmpresa(), dto.numeroCelular(),
					dto.role(), dto.cpfOrCnpj());

			repository.save(newUser);
			return new EnvelopeService<ResponseEntity>();
		}
	}

}
