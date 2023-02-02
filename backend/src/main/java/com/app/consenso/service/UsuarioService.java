package com.app.consenso.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.consenso.model.Usuario;

public interface UsuarioService extends JpaRepository<Usuario, Integer>{
    
}
