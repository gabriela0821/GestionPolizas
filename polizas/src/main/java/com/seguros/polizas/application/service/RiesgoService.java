package com.seguros.polizas.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.seguros.polizas.domain.model.Riesgo;
import com.seguros.polizas.domain.repository.RiesgoRepository;

@Service
public class RiesgoService {

    private final RiesgoRepository riesgoRepository;

    public RiesgoService(
            RiesgoRepository riesgoRepository) {
        this.riesgoRepository = riesgoRepository;
    }

    public void cancelarRiesgo(Long id){

        Riesgo riesgo = riesgoRepository.obtenerPorId(id);

        riesgo.cancelar();

        riesgoRepository.guardar(riesgo);
    }

    public List<Riesgo> listar(String tipo, Long polizaId){
        List<Riesgo> riesgos = riesgoRepository.obtenerTodos();

        return riesgos.stream()
            .filter(p -> tipo == null || p.getTipo().equals(tipo))
            .filter(p -> polizaId == null || p.getPolizaId().equals(polizaId))
            .toList();
    }

}