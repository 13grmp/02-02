package com.app.consenso.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.consenso.model.TipoUsuario;

public interface TipoUsuarioService extends JpaRepository<TipoUsuario, Integer>{
    
}
