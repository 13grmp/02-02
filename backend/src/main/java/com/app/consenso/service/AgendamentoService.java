package com.app.consenso.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.consenso.model.Agendamento;

public interface AgendamentoService extends JpaRepository<Agendamento, Integer>{
    // @Query("SELECT agendamento FROM Agendamento agendamento WHERE agendamento.usuario = idUsuario") //professor falou na aula mas ainda não entendi o que faz
    // public List<Agendamento> findByUsuarioId(@Param("idUsuario") Long id);
}
