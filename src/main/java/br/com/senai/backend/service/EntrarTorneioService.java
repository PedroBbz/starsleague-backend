package br.com.senai.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.backend.entity.EntrarTorneio;
import br.com.senai.backend.entity.Equipe;
import br.com.senai.backend.entity.Torneio;
import br.com.senai.backend.repository.EntrarTorneioRepository;
import br.com.senai.backend.repository.EquipeRepository;
import br.com.senai.backend.repository.TorneioRepository;

@Service
public class EntrarTorneioService {

    @Autowired
    private EntrarTorneioRepository entrarTorneioRepository;

    @Autowired
    private EquipeRepository equipeRepository;

    @Autowired
    private TorneioRepository torneioRepository;

    public EntrarTorneio adicionarEquipeAoTorneio(Long equipeId, Long torneioId){
        Equipe equipe = equipeRepository.findById(equipeId)
            .orElseThrow(() -> new RuntimeException("Equipe não encontrada"));
        Torneio torneio = torneioRepository.findById(torneioId)
            .orElseThrow(() -> new RuntimeException("Torneio não encontrado"));

        EntrarTorneio entrarTorneio = new EntrarTorneio();
        entrarTorneio.setEquipe(equipe);
        entrarTorneio.setTorneio(torneio);

        return entrarTorneioRepository.save(entrarTorneio);
    }

}
