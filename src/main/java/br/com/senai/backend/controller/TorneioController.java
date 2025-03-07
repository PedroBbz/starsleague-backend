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


import br.com.senai.backend.entity.Torneio;
import br.com.senai.backend.repository.TorneioRepository;
import br.com.senai.backend.service.TorneioService;

@RestController
@RequestMapping("/torneios")
public class TorneioController {

    @Autowired
    private TorneioService torneioService;

    @Autowired
    private TorneioRepository torneioRepository;

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

    @PostMapping("/torneios")
    public ResponseEntity<Torneio> criarTorneio(@RequestBody Torneio torneio) {
        Torneio novoTorneio = torneioRepository.save(torneio);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoTorneio);
    }

    @PostMapping(consumes = { "multipart/form-data" })
    public ResponseEntity<Torneio> criarTorneio(
            @RequestParam("nome_torneio") String nome_torneio,
            @RequestParam("n_de_equipes") int n_de_equipes,
            @RequestParam("jogo") String jogo,
            @RequestParam("entrada") String entrada,
            @RequestParam("chaveamento") String chaveamento,
            @RequestParam("image") MultipartFile imageFile) {
        try {
            // Converter a imagem para um array de bytes (byte[])
            byte[] imageBytes = imageFile.getBytes();

            // Criar uma nova equipe com os dados recebidos
            Torneio torneio = new Torneio();
            torneio.setNome_torneio(nome_torneio);
            torneio.setN_de_equipes(n_de_equipes);
            torneio.setJogo(jogo);
            torneio.setEntrada(entrada);
            torneio.setChaveamento(chaveamento);
            torneio.setImage(imageBytes);

            // Salvar no banco
            Torneio torneioSalvo = torneioRepository.save(torneio);

            // Retornar a equipe salva com status 201 (Created)
            return ResponseEntity.status(HttpStatus.CREATED).body(torneioSalvo);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
