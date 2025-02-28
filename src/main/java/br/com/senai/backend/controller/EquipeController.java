package br.com.senai.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.backend.entity.Equipe;
import br.com.senai.backend.service.EquipeService;

@RestController
@RequestMapping("/equipes")
public class EquipeController {

    @Autowired
    private EquipeService equipeService;

    @GetMapping
    public ResponseEntity<List<Equipe>> findAll() {
        List<Equipe> equipes = equipeService.findAll();
        return ResponseEntity.ok().body(equipes);
    }

    @GetMapping("{id}")
    public ResponseEntity<Equipe> findById(@PathVariable Long id) {
        Equipe equipe = equipeService.findById(id);
        return ResponseEntity.ok().body(equipe);
    }

    @PostMapping
    public ResponseEntity<Equipe> insertNew(@RequestBody Equipe equipe) {
        Equipe equipeInserido = equipeService.insertNew(equipe);
        return ResponseEntity.ok().body(equipeInserido);
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id) {
        Boolean flag = equipeService.deleteById(id);
        return ResponseEntity.ok().body(flag);
    }

    @PutMapping("{id}")
    public ResponseEntity<Equipe> update(@PathVariable Long id, @RequestBody Equipe equipeAtual) {
        Equipe equipe = equipeService.update(id, equipeAtual);
        return ResponseEntity.ok().body(equipe);
    }

}
