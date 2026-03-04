package com.seguros.polizas.infrastructure.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RiesgoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long polizaId;
    private String tipo;
    private String estado;
    private LocalDate fechaActualizacion;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getPolizaId() { return polizaId; }
    public void setPolizaId(Long polizaId) { this.polizaId = polizaId; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public LocalDate getFechaActualizacion() { return fechaActualizacion; }
    public void setFechaActualizacion(LocalDate fechaActualizacion) { this.fechaActualizacion = fechaActualizacion; }

}