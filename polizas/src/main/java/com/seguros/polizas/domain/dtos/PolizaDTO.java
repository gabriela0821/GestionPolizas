package com.seguros.polizas.domain.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PolizaDTO(
    String tipo,
    BigDecimal canonMensual,
    BigDecimal prima,
    Integer mesesVigencia,
    LocalDate fechaInicio
) {}