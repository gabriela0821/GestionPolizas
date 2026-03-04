package com.seguros.polizas.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Poliza {

    private Long id;
    private String tipo;
    private String estado;

    private BigDecimal canonMensual;
    private BigDecimal prima;

    private Integer mesesVigencia;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public Poliza(Long id, String tipo, String estado,
                  BigDecimal canonMensual, BigDecimal prima,
                  Integer mesesVigencia, LocalDate fechaInicio, LocalDate fechaFin) {

        this.id = id;
        this.tipo = tipo;
        this.estado = estado;
        this.canonMensual = canonMensual;
        this.prima = prima;
        this.mesesVigencia = mesesVigencia;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Long getId() { return id; }
    public String getTipo() { return tipo; }
    public String getEstado() { return estado; }
    public BigDecimal getCanonMensual() { return canonMensual; }
    public BigDecimal getPrima() { return prima; }
    public Integer getMesesVigencia() {
        return mesesVigencia;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void renovar(double ipc){

        if("CANCELADA".equals(this.estado)){
            throw new RuntimeException("No se puede renovar una póliza cancelada");
        }

        this.canonMensual = canonMensual.multiply(BigDecimal.valueOf(1 + ipc));
        this.prima = prima.multiply(BigDecimal.valueOf(1 + ipc));

        this.estado = "RENOVADA";
    }

    public void cancelar(){
        this.estado = "CANCELADA";
    }

}