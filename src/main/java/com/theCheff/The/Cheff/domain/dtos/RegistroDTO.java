package com.theCheff.The.Cheff.domain.dtos;

import com.theCheff.The.Cheff.domain.enums.UserRole;

public record RegistroDTO(String login, String senha, String nomeDaEmpresa, String numeroCelular, UserRole role,
		String cpfOrCnpj) {
}