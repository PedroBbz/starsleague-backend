package br.com.senai.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.backend.entity.Equipe;
import br.com.senai.backend.repository.EquipeRepository;

@Service
public class EquipeService {

     @Autowired
    private EquipeRepository equipeRepository;

    public List<Equipe> findAll() {
        return equipeRepository.findAll();
    }

    public Equipe findById(Long id) {
        return equipeRepository.findById(id).orElse(null);
    }

    public Equipe insertNew(Equipe equipe) {
        return equipeRepository.save(equipe);
    }

    public Boolean deleteById(Long id) {
        Equipe equipe = findById(id);
        if (equipe == null) {
            return false;
        } else {
            equipeRepository.deleteById(id);
            return true;
        }
    }

    public Equipe update(Long id, Equipe equipeAtual) {
        Equipe equipe = findById(id);
        equipe.setN_participantes(equipeAtual.getN_participantes());
        equipe.setNome_equipe(equipeAtual.getNome_equipe());
        equipe.setImage(equipeAtual.getImage());
        return equipeRepository.save(equipe);
    }

}
