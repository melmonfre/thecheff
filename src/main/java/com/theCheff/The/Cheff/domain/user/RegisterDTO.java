package com.theCheff.The.Cheff.domain.user;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

// public record RegisterDTO(
//     String login,
//      String password,
//       UserRole role,
//       String nomeDaEmpresa,
//       String cpfOrCnpj,
//       String numeroCelular) {
// }


public record RegisterDTO(
    String login,
    String password,
    UserRole role,
    String nomeDaEmpresa,
    String numeroCelular,
    String cpfOrCnpj
) {}
