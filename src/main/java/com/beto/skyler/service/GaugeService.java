package com.beto.skyler.service;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;

@Service
public class GaugeService {

    private final AtomicInteger gaugeValue;

    public GaugeService(MeterRegistry meterRegistry) {
        this.gaugeValue = new AtomicInteger(0);

        Gauge.builder("meu_gauge", gaugeValue, AtomicInteger::get)
                .description("Um gauge para monitorar um valor variável")
                .register(meterRegistry);
    }

    public void incrementar() {
        gaugeValue.incrementAndGet();
    }

    public void decrementar() {
        gaugeValue.decrementAndGet();
    }

    public int obterValor() {
        return gaugeValue.get();
    }
}
