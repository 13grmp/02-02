package com.app.consenso.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NonNull;

@Data
@Entity
public class Usuario {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int idUsuario;
    //nome nao pode ser um campo vazio
    private String nome;
    private String sobrenome;
    private String email;
    private String senha;
 
    @JoinColumn(name="usuario_tipousuarioid")
    @OneToOne
    private TipoUsuario tipoUsuario;
    
}
// @OneToOne
