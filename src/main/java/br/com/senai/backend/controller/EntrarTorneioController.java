package br.com.senai.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.backend.entity.EntrarTorneio;
import br.com.senai.backend.service.EntrarTorneioService;

@RestController
@RequestMapping("/api/equipe-torneio")
public class EntrarTorneioController {

    @Autowired
    private EntrarTorneioService entrarTorneioService;

    @PostMapping("/{equipeId}/{torneioId}")
    public ResponseEntity<EntrarTorneio> adicionarEquipeAoTorneio(
        @PathVariable Long equipeId, @PathVariable Long torneioId){
            return ResponseEntity.ok(entrarTorneioService.adicionarEquipeAoTorneio(equipeId, torneioId));
        }
}
