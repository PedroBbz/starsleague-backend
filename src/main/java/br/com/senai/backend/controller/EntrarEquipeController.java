package br.com.senai.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.backend.entity.EntrarEquipe;
import br.com.senai.backend.service.EntrarEquipeService;

@RestController
@RequestMapping("/api/participante-equipe")
public class EntrarEquipeController {

    @Autowired
    private EntrarEquipeService entrarEquipeService;

    @PostMapping("/{participanteId}/{equipeId}")
    public ResponseEntity<EntrarEquipe> adicionarParticipanteAEquipe(
        @PathVariable Long participanteId, @PathVariable Long equipeId) {
            return ResponseEntity.ok(entrarEquipeService.adicionarParticipanteAEquipe(participanteId, equipeId));
        }
  
}
