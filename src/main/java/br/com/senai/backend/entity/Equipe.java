package br.com.senai.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Equipe {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int n_participantes;
    private String nome_equipe;
}
