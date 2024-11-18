package com.theCheff.The.Cheff.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.theCheff.The.Cheff.domain.model.entity.Restaurante;
import com.theCheff.The.Cheff.domain.model.repository.RestauranteRepository;
import com.theCheff.The.Cheff.util.EnvelopeService;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    public List<Restaurante> listarTodos() {
        return restauranteRepository.findAll();
    }

    public Optional<Restaurante> buscarPorId(Integer id) {
        return restauranteRepository.findById(id);
    }

    public Restaurante salvar(Restaurante restaurante) {
        return restauranteRepository.save(restaurante);
    }
    
    public EnvelopeService<Restaurante> criarRestaurante (Restaurante restaurante){
    	Restaurante save = restauranteRepository.save(restaurante);
    	EnvelopeService<Object> email = getEmail();
    	return new EnvelopeService<Restaurante>(save);
    }

    public Restaurante atualizar(Integer id, Restaurante restauranteAtualizado) {
        if (restauranteRepository.existsById(id)) {
            restauranteAtualizado.setIdRestaurante(id);
            return restauranteRepository.save(restauranteAtualizado);
        }
        return null;
    }
    
    public EnvelopeService<Object> getEmail(){
    	Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	return new EnvelopeService<Object>(principal);
    }

    public void deletar(Integer id) {
        restauranteRepository.deleteById(id);
    }
}