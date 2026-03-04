package com.seguros.polizas.infrastructure.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.seguros.polizas.domain.model.Riesgo;
import com.seguros.polizas.domain.repository.RiesgoRepository;
import com.seguros.polizas.infrastructure.entity.RiesgoEntity;
import com.seguros.polizas.infrastructure.mapper.RiesgoMapper;

@Repository
public class RiesgoRepositoryImpl implements RiesgoRepository {

    private final JpaRiesgoRepository jpaRepository;

    public RiesgoRepositoryImpl(JpaRiesgoRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Riesgo guardar(Riesgo riesgo) {

        RiesgoEntity entity = RiesgoMapper.toEntity(riesgo);
        entity.setFechaActualizacion(LocalDate.now());
        RiesgoEntity saved = jpaRepository.save(entity);

        return RiesgoMapper.toDomain(saved);
    }

    @Override
    public List<Riesgo> obtenerPorPoliza(Long polizaId) {
       
        List<RiesgoEntity> riesgos = jpaRepository.findByPolizaId(polizaId);
    
        if (riesgos.isEmpty()) {
            throw new RuntimeException("Riesgos no encontrados para la póliza: " + polizaId);
        }

        return riesgos.stream()
                .map(RiesgoMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Riesgo> obtenerTodos() {
        return jpaRepository
            .findAll()
            .stream()
            .map(RiesgoMapper::toDomain)
            .collect(Collectors.toList());
    }

    @Override
    public Riesgo obtenerPorId(Long id) {
        return jpaRepository
        .findById(id)
        .map(RiesgoMapper::toDomain)
        .orElseThrow(()->new RuntimeException("Riesgo no encontrado"));
    }

}