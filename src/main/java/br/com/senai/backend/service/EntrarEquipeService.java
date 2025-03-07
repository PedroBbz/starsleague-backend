package br.com.senai.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.backend.entity.EntrarEquipe;
import br.com.senai.backend.entity.Equipe;
import br.com.senai.backend.entity.Participante;
import br.com.senai.backend.repository.EntrarEquipeRepository;
import br.com.senai.backend.repository.EquipeRepository;
import br.com.senai.backend.repository.ParticipanteRepository;

@Service
public class EntrarEquipeService {

    @Autowired
    private EntrarEquipeRepository entrarEquipeRepository;

    @Autowired
    private ParticipanteRepository participanteRepository;

    @Autowired
    private EquipeRepository equipeRepository;

    public EntrarEquipe adicionarParticipanteAEquipe(Long participanteId, Long equipeId){
        Participante participante = participanteRepository.findById(participanteId)
            .orElseThrow(() -> new RuntimeException("Participante não encontrado"));
        Equipe equipe = equipeRepository.findById(equipeId)
            .orElseThrow(() -> new RuntimeException("Equipe não encontrada"));

        EntrarEquipe entrarEquipe = new EntrarEquipe();
        entrarEquipe.setParticipante(participante);
        entrarEquipe.setEquipe(equipe);   
        
        return entrarEquipeRepository.save(entrarEquipe);
    }

}
