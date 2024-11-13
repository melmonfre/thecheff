package com.theCheff.The.Cheff.domain.model.entity;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.theCheff.The.Cheff.domain.enums.UserRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Table(name = "usuarios")
@Entity(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
public class Usuarios implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Email
    @NotNull
    private String login;
    @Size(min = 8)
    @NotNull
    private String senha;
    private UserRole role;
    private String nomeDaEmpresa;
    private String cpfOrCnpj;
    private String numeroCelular;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updatedAt")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Usuarios(String login, String senha, UserRole role) {
        this.login = login;
        this.senha = senha;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == UserRole.ADMIN)
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        else
            return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return senha;
    }

    public Usuarios(String login, String senha, String nomeDaEmpresa, String numeroCelular, UserRole role,
            String cpfOrCnpj) {
        this.login = login;
        this.senha = senha;
        this.nomeDaEmpresa = nomeDaEmpresa;
        this.numeroCelular = numeroCelular;
        this.role = role;
        this.cpfOrCnpj = cpfOrCnpj;
    }
}