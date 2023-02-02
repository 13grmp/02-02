package com.app.consenso.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.consenso.model.Servico;

public interface ServicoService extends JpaRepository<Servico, Integer>{
    
}
