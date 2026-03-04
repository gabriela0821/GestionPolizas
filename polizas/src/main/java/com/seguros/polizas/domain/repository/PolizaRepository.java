package com.seguros.polizas.domain.repository;

import java.util.List;

import com.seguros.polizas.domain.model.Poliza;

public interface PolizaRepository {

    Poliza guardar(Poliza poliza);

    List<Poliza> obtenerTodas();

    Poliza obtenerPorId(Long id);
}