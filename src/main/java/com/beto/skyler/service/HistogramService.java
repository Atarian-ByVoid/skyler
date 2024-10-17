package com.beto.skyler.service;

import org.springframework.stereotype.Service;

import io.micrometer.core.instrument.DistributionSummary;
import io.micrometer.core.instrument.MeterRegistry;

@Service
public class HistogramService {

    private final DistributionSummary responseTimeHistogram;

    public HistogramService(MeterRegistry meterRegistry) {
        this.responseTimeHistogram = DistributionSummary.builder("tempo_resposta_histogram")
                .description("Histograma de tempo de resposta")
                .baseUnit("milliseconds")
                .register(meterRegistry);
    }

    public void registrarTempoDeResposta(double tempo) {
        responseTimeHistogram.record(tempo);
    }
    
}
