package com.theCheff.The.Cheff.domain.user;

public record RegisterDTO(String login, String password, UserRole role) {
}