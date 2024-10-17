package com.beto.skyler.service;

import org.springframework.stereotype.Service;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;

@Service
public class UsuarioService {
    
    private final Counter meuContador;

        public UsuarioService(MeterRegistry meterRegistry) {
        this.meuContador = meterRegistry.counter("meu_contador", "tipo", "acao");
    }
    
    public void findById() {
        meuContador.increment();
        System.out.println("Ação executada. Contador incrementado.");
    }
    
}
