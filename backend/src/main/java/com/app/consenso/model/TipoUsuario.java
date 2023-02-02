package com.app.consenso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class TipoUsuario {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int idTipoUsuario;
    private String nome;    
    
}