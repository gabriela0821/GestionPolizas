package com.seguros.polizas.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seguros.polizas.infrastructure.entity.PolizaEntity;

public interface JpaPolizaRepository extends JpaRepository<PolizaEntity, Long> {

}