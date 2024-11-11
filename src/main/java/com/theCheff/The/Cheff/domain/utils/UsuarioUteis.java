package com.theCheff.The.Cheff.domain.utils;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.theCheff.The.Cheff.domain.repository.UserRepository;
import com.theCheff.The.Cheff.domain.user.User;
@Component


public class UsuarioUteis {

    @Autowired
    private UserRepository userRepository;

    public String getNomeUsuarioLogado(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }


    public UserDetails getUsuarioLogadoPorId() {
        String username = getNomeUsuarioLogado();
        return userRepository.findByLogin(username); 
    
    }
}
