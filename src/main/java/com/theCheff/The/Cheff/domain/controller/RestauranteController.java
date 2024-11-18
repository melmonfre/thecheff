package com.theCheff.The.Cheff.domain.controller;

import java.security.Provider.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.theCheff.The.Cheff.domain.model.entity.Restaurante;
import com.theCheff.The.Cheff.domain.service.RestauranteService;
import com.theCheff.The.Cheff.util.EnvelopeService;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    @Autowired
    private RestauranteService restauranteService;

    @GetMapping
    public ResponseEntity<List<Restaurante>> listarTodos() {
        List<Restaurante> restaurantes = restauranteService.listarTodos();
        return ResponseEntity.ok(restaurantes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurante> buscarPorId(@PathVariable Integer id) {
        Optional<Restaurante> restaurante = restauranteService.buscarPorId(id);
        return restaurante.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

//    @PostMapping
//    public ResponseEntity<Restaurante> criar(@RequestBody Restaurante restaurante) {
//        Restaurante novoRestaurante = restauranteService.salvar(restaurante);
//        return ResponseEntity.status(HttpStatus.CREATED).body(novoRestaurante);
//    }
    
    @PostMapping
    public EnvelopeService<Restaurante> salvarRestaurante (@RequestBody Restaurante restaurante){
    	EnvelopeService<Restaurante> criarRestaurante = restauranteService.criarRestaurante(restaurante);
    	return criarRestaurante;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Restaurante> atualizar(@PathVariable Integer id, @RequestBody Restaurante restaurante) {
        Restaurante restauranteAtualizado = restauranteService.atualizar(id, restaurante);
        return restauranteAtualizado != null ? ResponseEntity.ok(restauranteAtualizado)
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        restauranteService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}