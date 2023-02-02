package com.app.consenso.model;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
public class Agendamento {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int idAgendamento;
    // @NonNull
    private LocalDate data;
    // @NonNull
    private LocalTime hora;

    // @Query("SELECT a FROM Agendamento nickname WHERE ")
    // public List<Agendamento> findByUsuarioId(Long id){
        
    // }
    @OneToOne
    private Servico servico;
    @OneToOne
    private Usuario usuario;
}
