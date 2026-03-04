package com.seguros.polizas.infrastructure.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PolizaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String tipo;
    private String estado;
    private BigDecimal canonMensual;
    private BigDecimal prima;
    private Integer mesesVigencia;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public BigDecimal getCanonMensual() { return canonMensual; }
    public void setCanonMensual(BigDecimal canonMensual) { this.canonMensual = canonMensual; }

    public BigDecimal getPrima() { return prima; }
    public void setPrima(BigDecimal prima) { this.prima = prima; }

    public Integer getMesesVigencia() { return mesesVigencia; }
    public void setMesesVigencia(Integer mesesVigencia) { this.mesesVigencia = mesesVigencia; }

    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }

    public LocalDate getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }
}