package br.com.senai.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senai.backend.entity.Organizador;

@Repository
public interface OrganizadorRepository extends JpaRepository<Organizador, Long> {

}
