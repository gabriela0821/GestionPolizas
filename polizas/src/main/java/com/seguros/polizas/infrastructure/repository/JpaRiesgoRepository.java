package com.seguros.polizas.infrastructure.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seguros.polizas.infrastructure.entity.RiesgoEntity;

public interface JpaRiesgoRepository extends JpaRepository<RiesgoEntity, Long> {

    List<RiesgoEntity> findByPolizaId(Long polizaId);

}