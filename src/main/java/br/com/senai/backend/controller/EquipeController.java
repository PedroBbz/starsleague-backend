package br.com.senai.backend.controller;

import java.io.IOException;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.senai.backend.entity.Equipe;
import br.com.senai.backend.repository.EquipeRepository;
import br.com.senai.backend.service.EquipeService;

@RestController
@RequestMapping("/equipes")
public class EquipeController {

    @Autowired
    private EquipeService equipeService;

    @Autowired
    private EquipeRepository equipeRepository;

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

    @PostMapping("/equipes")
    public ResponseEntity<Equipe> criarEquipe(@RequestBody Equipe equipe) {
        Equipe novaEquipe = equipeRepository.save(equipe);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaEquipe);
    }

    @PostMapping(consumes = { "multipart/form-data" })
    public ResponseEntity<Equipe> criarEquipe(
            @RequestParam("nome_equipe") String nome_equipe,
            @RequestParam("n_participantes") int n_participantes,
            @RequestParam("image") MultipartFile imageFile) {
        try {
            // Converter a imagem para um array de bytes (byte[])
            byte[] imageBytes = imageFile.getBytes();

            // Criar uma nova equipe com os dados recebidos
            Equipe equipe = new Equipe();
            equipe.setNome_equipe(nome_equipe);
            equipe.setN_participantes(n_participantes);
            equipe.setImage(imageBytes);

            // Salvar no banco
            Equipe equipeSalva = equipeRepository.save(equipe);

            // Retornar a equipe salva com status 201 (Created)
            return ResponseEntity.status(HttpStatus.CREATED).body(equipeSalva);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
