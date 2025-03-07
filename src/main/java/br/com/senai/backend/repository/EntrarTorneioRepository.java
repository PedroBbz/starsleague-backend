package br.com.senai.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senai.backend.entity.EntrarTorneio;

@Repository
public interface EntrarTorneioRepository extends JpaRepository<EntrarTorneio, Long>{
    List<EntrarTorneio> findByTorneioId(Long torneioId);

}
