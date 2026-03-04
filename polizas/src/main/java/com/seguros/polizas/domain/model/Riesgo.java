package com.seguros.polizas.domain.model;

import java.time.LocalDate;

public class Riesgo {

    private Long id;
    private Long polizaId;
    private String tipo;
    private String estado;
    private LocalDate fechaActualizacion;

    public Riesgo(Long id, Long polizaId,String tipo, String estado, LocalDate fechaActualizacion) {
        this.id = id;
        this.polizaId = polizaId;
        this.tipo = tipo;
        this.estado = estado;
        this.fechaActualizacion = fechaActualizacion;
    }

    public Long getId() {
        return id;
    }

    public Long getPolizaId() {
        return polizaId;
    }

    
    public String getTipo() {
        return tipo;
    }

    public String getEstado() {
        return estado;
    }

    
    public LocalDate getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void cancelar() {
        this.estado = "CANCELADO";
    }
}