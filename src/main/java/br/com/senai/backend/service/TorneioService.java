package br.com.senai.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.backend.entity.Torneio;
import br.com.senai.backend.repository.TorneioRepository;

@Service
public class TorneioService {

    @Autowired
    private TorneioRepository torneioRepository;

    public List<Torneio> findAll() {
        return torneioRepository.findAll();
    }

    public Torneio findById(Long id) {
        return torneioRepository.findById(id).orElse(null);
    }

    public Torneio insertNew(Torneio torneio) {
        return torneioRepository.save(torneio);
    }

    public Boolean deleteById(Long id) {
        Torneio torneio = findById(id);
        if (torneio == null) {
            return false;
        } else {
            torneioRepository.deleteById(id);
            return true;
        }
    }

    public Torneio update(Long id, Torneio torneioAtual) {
        Torneio torneio = findById(id);
        torneio.setN_de_equipes(torneioAtual.getN_de_equipes());
        torneio.setNome_torneio(torneioAtual.getNome_torneio());
        torneio.setJogo(torneioAtual.getJogo());
        torneio.setEntrada(torneioAtual.getEntrada());
        torneio.setChaveamento(torneioAtual.getChaveamento());
        torneio.setTipo_sala(torneioAtual.getTipo_sala());
        torneio.setImage(torneioAtual.getImage());
        return torneioRepository.save(torneio);
    }

}