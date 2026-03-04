package com.seguros.polizas.infrastructure.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.seguros.polizas.domain.model.Poliza;
import com.seguros.polizas.domain.repository.PolizaRepository;
import com.seguros.polizas.infrastructure.entity.PolizaEntity;
import com.seguros.polizas.infrastructure.mapper.PolizaMapper;

@Repository
public class PolizaRepositoryImpl implements PolizaRepository {

    private final JpaPolizaRepository jpaRepository;

    public PolizaRepositoryImpl(JpaPolizaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Poliza guardar(Poliza poliza) {

        PolizaEntity entity = PolizaMapper.toEntity(poliza);
        PolizaEntity saved = jpaRepository.save(entity);

        return PolizaMapper.toDomain(saved);
    }

    
    @Override
    public List<Poliza> obtenerTodas() {
        return jpaRepository
            .findAll()
            .stream()
            .map(PolizaMapper::toDomain)
            .collect(Collectors.toList());
    }

    @Override
    public Poliza obtenerPorId(Long id) {
        return jpaRepository
        .findById(id)
        .map(PolizaMapper::toDomain)
        .orElseThrow(()->new RuntimeException("Póliza no encontrada"));
    }

}