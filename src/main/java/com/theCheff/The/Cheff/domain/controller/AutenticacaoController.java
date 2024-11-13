package com.theCheff.The.Cheff.domain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.theCheff.The.Cheff.domain.dtos.AutenticacaoDTO;
import com.theCheff.The.Cheff.domain.dtos.LoginResponseDTO;
import com.theCheff.The.Cheff.domain.dtos.RegistroDTO;
import com.theCheff.The.Cheff.domain.enums.UserRole;
import com.theCheff.The.Cheff.domain.model.entity.Usuarios;
import com.theCheff.The.Cheff.domain.model.repository.UsuariosRepository;
import com.theCheff.The.Cheff.infra.security.TokenService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("auth")
public class AutenticacaoController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UsuariosRepository repository;
	@Autowired
	private TokenService tokenService;

	@PostMapping("/login")
	public ResponseEntity login(@RequestBody @Valid AutenticacaoDTO data) {
		var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.senha());
		var auth = this.authenticationManager.authenticate(usernamePassword);

		var token = tokenService.generateToken((Usuarios) auth.getPrincipal());
		return ResponseEntity.ok(new LoginResponseDTO(token));
	}

	@PostMapping("/register")
	public ResponseEntity register(@RequestBody @Valid RegistroDTO data) {
		if (this.repository.findUserDetailsByLogin(data.login()) != null)
			return ResponseEntity.badRequest().build();

		String encryptedPassword = new BCryptPasswordEncoder().encode(data.senha());
		Usuarios newUser = new Usuarios(data.login(), encryptedPassword, data.nomeDaEmpresa(), data.numeroCelular(),
				data.role(), data.cpfOrCnpj());

		this.repository.save(newUser);

		return ResponseEntity.ok().build();
	}
}
