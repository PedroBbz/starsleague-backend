package br.com.senai.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senai.backend.entity.EntrarEquipe;

@Repository
public interface EntrarEquipeRepository extends JpaRepository<EntrarEquipe, Long>{
    List<EntrarEquipe> findByEquipeId(Long equipeId);

}
