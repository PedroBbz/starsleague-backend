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

import br.com.senai.backend.entity.Participante;
import br.com.senai.backend.repository.ParticipanteRepository;
import br.com.senai.backend.service.ParticipanteService;

@RestController
@RequestMapping("/participantes")
public class ParticipanteController {

    @Autowired
    private ParticipanteRepository participanteRepository;

    @Autowired
    private ParticipanteService participanteService;

    @GetMapping
    public ResponseEntity<List<Participante>> findAll(){
        List<Participante> participantes = participanteService.findAll();
        return ResponseEntity.ok().body(participantes);
    }

    @GetMapping("{id}")
    public ResponseEntity<Participante> findById(@PathVariable Long id){
        Participante participante = participanteService.findById(id);
        return ResponseEntity.ok().body(participante);
    }

    @PostMapping
    public ResponseEntity<Participante> insertNew(@RequestBody Participante participante){
        Participante participanteInserido = participanteService.insertNew(participante);
        return ResponseEntity.ok().body(participanteInserido);     
    }
    
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id){
        Boolean flag = participanteService.deleteById(id);
        return ResponseEntity.ok().body(flag);
    }

    @PutMapping("{id}")
    public ResponseEntity<Participante> update(@PathVariable Long id, @RequestBody Participante participanteAtual){
        Participante participante = participanteService.update(id, participanteAtual);
        return ResponseEntity.ok().body(participante);
    }

}




