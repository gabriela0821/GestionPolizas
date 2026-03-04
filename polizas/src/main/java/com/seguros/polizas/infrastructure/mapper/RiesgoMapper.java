package com.seguros.polizas.infrastructure.mapper;

import com.seguros.polizas.domain.model.Riesgo;
import com.seguros.polizas.infrastructure.entity.RiesgoEntity;

public class RiesgoMapper {

    public static Riesgo toDomain(RiesgoEntity entity) {

        return new Riesgo(
                entity.getId(),
                entity.getPolizaId(),
                entity.getTipo(),
                entity.getEstado(),                
                entity.getFechaActualizacion()
        );
    }

    public static RiesgoEntity toEntity(Riesgo riesgo) {

        RiesgoEntity entity = new RiesgoEntity();

        entity.setId(riesgo.getId());
        entity.setPolizaId(riesgo.getPolizaId());
        entity.setTipo(riesgo.getTipo());
        entity.setEstado(riesgo.getEstado());
        entity.setFechaActualizacion(riesgo.getFechaActualizacion());

        return entity;
    }
}