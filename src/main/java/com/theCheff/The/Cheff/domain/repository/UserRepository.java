package com.theCheff.The.Cheff.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.theCheff.The.Cheff.domain.user.User;

public interface UserRepository extends JpaRepository<User, String> {
    UserDetails findByLogin(String login);
}
