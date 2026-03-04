package com.seguros.polizas.interfaces.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.seguros.polizas.application.service.RiesgoService;
import com.seguros.polizas.domain.dtos.RiesgoDTO;
import com.seguros.polizas.domain.model.Riesgo;

@RestController
@RequestMapping("/api/v1/riesgos")
public class RiesgoController {

    private final RiesgoService riesgoService;

    public RiesgoController(RiesgoService riesgoService){
        this.riesgoService = riesgoService;
    }

    @PostMapping("/{id}/Riesgo")
    public void cancelar(@PathVariable Long id){
        riesgoService.cancelarRiesgo(id);
    }

    @GetMapping
    public List<Riesgo> listar(
            @RequestParam(required = false) String tipo,
            @RequestParam(required = false) Long polizaId){

        return riesgoService.listar(tipo, polizaId);
    }
}