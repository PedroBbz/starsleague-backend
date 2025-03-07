package br.com.senai.backend.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class EntrarEquipe {
    
    @Id
    @JoinColumn
    private Long id;

    @ManyToOne
    @JoinColumn(name = "participante_id")
    private Participante participante;


    @ManyToOne
    @JoinColumn(name = "equipe_id")
    private Equipe equipe;

    private LocalDate dataEntrada;
    private String status;

}
