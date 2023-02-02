package com.app.consenso.model;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Servico {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int idServico;
    //usuario pode criar servico sem descricao, mas nao sem um nome
    private String nome;
    private String descricao;
    
    @OneToOne
    private Usuario usuario;

    // @OneToOne
    // public Agendamento agendamento;
}
