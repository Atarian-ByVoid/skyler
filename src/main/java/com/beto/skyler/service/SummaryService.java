package com.beto.skyler.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;
import io.micrometer.core.instrument.Timer;
import io.micrometer.core.instrument.MeterRegistry;

@Service
public class SummaryService {

        private final Timer responseTimeSummary;

    public SummaryService(MeterRegistry meterRegistry) {
        this.responseTimeSummary = Timer.builder("tempo_resposta_summary")
                .description("Sumário de tempo de resposta")
                .publishPercentiles(0.5, 0.9, 0.95) 
                .register(meterRegistry);
    }

    public void registrarTempoDeResposta(long tempo) {
        responseTimeSummary.record(tempo, TimeUnit.MILLISECONDS);
    }
}