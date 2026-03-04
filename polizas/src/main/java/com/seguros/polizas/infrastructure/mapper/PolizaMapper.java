package com.seguros.polizas.infrastructure.mapper;

import com.seguros.polizas.domain.model.Poliza;
import com.seguros.polizas.infrastructure.entity.PolizaEntity;

public class PolizaMapper {

    public static Poliza toDomain(PolizaEntity entity) {

        return new Poliza(
                entity.getId(),
                entity.getTipo(),
                entity.getEstado(),
                entity.getCanonMensual(),
                entity.getPrima(),
                entity.getMesesVigencia(),
                entity.getFechaInicio(),
                entity.getFechaFin()
        );
    }

    public static PolizaEntity toEntity(Poliza poliza) {

        PolizaEntity entity = new PolizaEntity();

        entity.setId(poliza.getId());
        entity.setTipo(poliza.getTipo());
        entity.setEstado(poliza.getEstado());
        entity.setCanonMensual(poliza.getCanonMensual());
        entity.setPrima(poliza.getPrima());
        entity.setMesesVigencia(poliza.getMesesVigencia());
        entity.setFechaInicio(poliza.getFechaInicio());
        entity.setFechaFin(poliza.getFechaFin());

        return entity;
    }
}