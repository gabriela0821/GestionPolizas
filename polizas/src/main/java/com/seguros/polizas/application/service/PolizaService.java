package com.seguros.polizas.application.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.seguros.polizas.domain.dtos.PolizaDTO;
import com.seguros.polizas.domain.dtos.RiesgoDTO;
import com.seguros.polizas.domain.model.Poliza;
import com.seguros.polizas.domain.model.Riesgo;
import com.seguros.polizas.domain.repository.PolizaRepository;
import com.seguros.polizas.domain.repository.RiesgoRepository;

@Service
public class PolizaService {

    private final PolizaRepository polizaRepository;
    private final RiesgoRepository riesgoRepository;

    public PolizaService(
            PolizaRepository polizaRepository,
            RiesgoRepository riesgoRepository) {

        this.polizaRepository = polizaRepository;
        this.riesgoRepository = riesgoRepository;
    }

   public List<Poliza> listar(String tipo, String estado){
        List<Poliza> polizas = polizaRepository.obtenerTodas();

        return polizas.stream()
            .filter(p -> tipo == null || p.getTipo().equals(tipo))
            .filter(p -> estado == null || p.getEstado().equals(estado))
            .toList();
    }

    public List<Riesgo> obtenerRiesgos(Long polizaId){
        return riesgoRepository.obtenerPorPoliza(polizaId);
    }

    public void renovar(Long id){

        Poliza poliza = polizaRepository.obtenerPorId(id);

        poliza.renovar(0.05);

        polizaRepository.guardar(poliza);
    }

    public void cancelarPoliza(Long id){

        Poliza poliza = polizaRepository.obtenerPorId(id);

        poliza.cancelar();

        List<Riesgo> riesgos = riesgoRepository.obtenerPorPoliza(id);

        for(Riesgo r : riesgos){
            r.cancelar();
        }

        polizaRepository.guardar(poliza);
    }

    public Poliza agregarPoliza(PolizaDTO dto){

        LocalDate inicio = (dto.fechaInicio() != null) ? dto.fechaInicio() : LocalDate.now();
        LocalDate fin = inicio.plusMonths(dto.mesesVigencia());

        Poliza nuevaPoliza = new Poliza(
            null,
            dto.tipo(),
            "ACTIVA",
            dto.canonMensual(),
            dto.prima(),
            dto.mesesVigencia(),
            inicio,
            fin
        );
        return polizaRepository.guardar(nuevaPoliza);
    }

    public Riesgo agregarRiesgo(RiesgoDTO riesgoDto){
    
        List<String> tiposValidos = List.of("INDIVIDUAL", "COLECTIVA");

        Poliza poliza = polizaRepository.obtenerPorId(riesgoDto.polizaId());

        if (poliza == null) {
            throw new RuntimeException("No se encontró la póliza con ID: " + riesgoDto.polizaId());
        }

        if (!tiposValidos.contains(poliza.getTipo())) {
            throw new RuntimeException("El tipo de póliza " + poliza.getTipo() + " no es válido en el sistema.");
        }

        if ("INDIVIDUAL".equals(poliza.getTipo())) {
            List<Riesgo> riesgosActuales = riesgoRepository.obtenerPorPoliza(poliza.getId());
            if (!riesgosActuales.isEmpty()) {
                throw new RuntimeException("Error: La póliza individual ya tiene un riesgo.");
            }
        }

        Riesgo riesgo = new Riesgo(null, riesgoDto.polizaId(), riesgoDto.tipo(), "ACTIVO",LocalDate.now());

        return riesgoRepository.guardar(riesgo);
    }

    public void cancelarRiesgo(Long id){

        Riesgo riesgo = riesgoRepository.obtenerPorId(id);

        riesgo.cancelar();

        riesgoRepository.guardar(riesgo);
    }


}