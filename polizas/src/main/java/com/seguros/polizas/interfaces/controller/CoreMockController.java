package com.seguros.polizas.interfaces.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/core-mock")
public class CoreMockController {

    public record EventoBody(String evento, Long polizaId) {}

    @PostMapping("/evento")
    public void evento(@RequestBody EventoBody body) {
        System.out.println("Evento: " + body.evento());
        System.out.println("ID: " + body.polizaId());
    }
}