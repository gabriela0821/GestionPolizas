package com.seguros.polizas.interfaces.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.seguros.polizas.application.service.PolizaService;
import com.seguros.polizas.domain.dtos.PolizaDTO;
import com.seguros.polizas.domain.dtos.RiesgoDTO;
import com.seguros.polizas.domain.model.Poliza;
import com.seguros.polizas.domain.model.Riesgo;

@RestController
@RequestMapping("/api/v1/polizas")
public class PolizaController {

    private final PolizaService polizaService;

    public PolizaController(PolizaService polizaService){
        this.polizaService = polizaService;
    }

    @GetMapping
    public List<Poliza> listar(
            @RequestParam(required = false) String tipo,
            @RequestParam(required = false) String estado){

        return polizaService.listar(tipo, estado);
    }

    @GetMapping("/{id}/riesgos")
    public List<Riesgo> riesgos(@PathVariable Long id){
        return polizaService.obtenerRiesgos(id);
    }

    @PostMapping("/{id}/renovar")
    public void renovar(@PathVariable Long id){
        polizaService.renovar(id);
    }

    @PostMapping("/{id}/cancelar")
    public void cancelar(@PathVariable Long id){
        polizaService.cancelarPoliza(id);
    }

    @PostMapping("/{id}/agregarPoliza")
    public Poliza agregarPoliza(@RequestBody PolizaDTO dto){
        return polizaService.agregarPoliza(dto);
    }

    @PostMapping("/{id}/agregarRiesgo")
    public Riesgo agregarRiesgo(@RequestBody RiesgoDTO dto){
        return polizaService.agregarRiesgo(dto);
    }
}