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

import br.com.senai.backend.entity.Organizador;
import br.com.senai.backend.service.OrganizadorService;

@RestController
@RequestMapping("/organizadores")
public class OrganizadorController {

    @Autowired
    private OrganizadorService organizadorService;

    @GetMapping
    public ResponseEntity<List<Organizador>> findAll(){
        List<Organizador> organizadores = organizadorService.findAll();
        return ResponseEntity.ok().body(organizadores);
    }

    @GetMapping("{id}")
    public ResponseEntity<Organizador> findById(@PathVariable Long id){
        Organizador organizador = organizadorService.findById(id);
        return ResponseEntity.ok().body(organizador);
    }

    @PostMapping
    public ResponseEntity<Organizador> insertNew(@RequestBody Organizador organizador){
        Organizador organizadorInserido = organizadorService.insertNew(organizador);
        return ResponseEntity.ok().body(organizadorInserido);     
    }
    
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id){
        Boolean flag = organizadorService.deleteById(id);
        return ResponseEntity.ok().body(flag);
    }

    @PutMapping("{id}")
    public ResponseEntity<Organizador> update(@PathVariable Long id, @RequestBody Organizador organizadorAtual){
        Organizador organizador = organizadorService.update(id, organizadorAtual);
        return ResponseEntity.ok().body(organizador);
    }

}
