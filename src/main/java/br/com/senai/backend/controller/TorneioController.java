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

import br.com.senai.backend.entity.Torneio;
import br.com.senai.backend.service.TorneioService;

@RestController
@RequestMapping("/torneios")
public class TorneioController {

    @Autowired
    private TorneioService torneioService;

    @GetMapping
    public ResponseEntity<List<Torneio>> findAll(){
        List<Torneio> torneios = torneioService.findAll();
        return ResponseEntity.ok().body(torneios);
    }

    @GetMapping("{id}")
    public ResponseEntity<Torneio> findById(@PathVariable Long id){
        Torneio torneio = torneioService.findById(id);
        return ResponseEntity.ok().body(torneio);
    }

    @PostMapping
    public ResponseEntity<Torneio> insertNew(@RequestBody Torneio torneio){
        Torneio torneioInserido = torneioService.insertNew(torneio);
        return ResponseEntity.ok().body(torneioInserido);     
    }
    
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id){
        Boolean flag = torneioService.deleteById(id);
        return ResponseEntity.ok().body(flag);
    }

    @PutMapping("{id}")
    public ResponseEntity<Torneio> update(@PathVariable Long id, @RequestBody Torneio torneioAtual){
        Torneio torneio = torneioService.update(id, torneioAtual);
        return ResponseEntity.ok().body(torneio);
    }
}
