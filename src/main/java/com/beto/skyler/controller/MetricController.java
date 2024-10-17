package com.beto.skyler.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beto.skyler.service.GaugeService;
import com.beto.skyler.service.HistogramService;
import com.beto.skyler.service.SummaryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "metric")
@RequiredArgsConstructor
public class MetricController {

    private final GaugeService gaugeService;
    private final HistogramService histogramService;
    private final SummaryService summaryService;

    @Scheduled(fixedRate = 500) 
    @GetMapping("/gauge/incrementar")
    public String incrementarGauge() {
        gaugeService.incrementar();
        return "Gauge incrementado! Valor atual: " + gaugeService.obterValor();
    }

    // @Scheduled(fixedRate = 2000) 
    @GetMapping("/gauge/decrementar")
    public String decrementarGauge() {
        gaugeService.decrementar();
        return "Gauge decrementado! Valor atual: " + gaugeService.obterValor();
    }

    @Scheduled(fixedRate = 2000) 
    @GetMapping("/histogram/registrar")
    public String registrarHistogram() {
        double tempo = Math.random() * 1000;  
        histogramService.registrarTempoDeResposta(tempo);
        return "Tempo registrado no histograma: " + tempo + " ms";
    }

    @Scheduled(fixedRate = 2000) 
    @GetMapping("/summary/registrar")
    public String registrarSummary() {
        long tempo = (long) (Math.random() * 1000);  
        summaryService.registrarTempoDeResposta(tempo);
        return "Tempo registrado no summary: " + tempo + " ms";
    }
    
}
