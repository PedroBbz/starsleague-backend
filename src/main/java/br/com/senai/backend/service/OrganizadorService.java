package br.com.senai.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.backend.entity.Organizador;
import br.com.senai.backend.repository.OrganizadorRepository;

@Service
public class OrganizadorService {

    
    @Autowired
    private OrganizadorRepository organizadorRepository;

    public List<Organizador> findAll() {
        return organizadorRepository.findAll();
    }

    public Organizador findById(Long id) {
        return organizadorRepository.findById(id).orElse(null);
    }

    public Organizador insertNew(Organizador organizador) {
        return organizadorRepository.save(organizador);
    }

    public Boolean deleteById(Long id) {
        Organizador organizador = findById(id);
        if (organizador == null) {
            return false;
        } else {
            organizadorRepository.deleteById(id);
            return true;
        }
    }

    public Organizador update(Long id, Organizador organizadorAtual) {
        Organizador organizador = findById(id);
        organizador.setNome(organizadorAtual.getNome());
        organizador.setEmail(organizadorAtual.getEmail());
        organizador.setSenha(organizadorAtual.getSenha());
        organizador.setImage(organizadorAtual.getImage());
        return organizadorRepository.save(organizador);
    }
}
