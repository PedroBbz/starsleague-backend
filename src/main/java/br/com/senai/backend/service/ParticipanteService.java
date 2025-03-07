package br.com.senai.backend.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.senai.backend.entity.Participante;
import br.com.senai.backend.repository.ParticipanteRepository;

@Service
public class ParticipanteService {

    @Autowired
    private ParticipanteRepository participanteRepository;

    public List<Participante> findAll() {
        return participanteRepository.findAll();
    }

    public Participante findById(Long id){
        return participanteRepository.findById(id).orElse(null);
    }

    public Participante insertNew(Participante participante) {
        return participanteRepository.save(participante);
    }

    public Boolean deleteById(Long id) {
        Participante participante = findById(id);
        if (participante == null) {
            return false;
        } else {
            participanteRepository.deleteById(id);
            return true;
        }
    }

    public Participante update(Long id, Participante participanteAtual){
        Participante participante=findById(id);
        participante.setNome(participanteAtual.getNome());
        participante.setEmail(participanteAtual.getEmail());
        participante.setSenha(participanteAtual.getSenha());
        participante.setImage(participanteAtual.getImage());
        return participanteRepository.save(participante);
    }
}