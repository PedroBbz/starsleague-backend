package br.com.senai.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Torneio {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int n_de_equipes;
    private String nome_torneio;
    private Boolean gratuito;
}
