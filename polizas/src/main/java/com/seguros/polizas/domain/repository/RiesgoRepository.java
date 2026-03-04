package com.seguros.polizas.domain.repository;

import java.util.List;

import com.seguros.polizas.domain.model.Riesgo;

public interface RiesgoRepository{

    Riesgo guardar(Riesgo riesgo);

    List<Riesgo> obtenerPorPoliza(Long polizaId);

    Riesgo obtenerPorId(Long id);
    
    List<Riesgo> obtenerTodos();
}