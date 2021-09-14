package com.jj.cambioservice.controller;

import com.jj.cambioservice.model.Cambio;
import com.jj.cambioservice.service.CambioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;

@RestController
@RequestMapping("cambio-service")
@Tag(name = "Cambio endpoint")
public class CambioController {

    @Autowired
    private Environment environment;

    @Autowired
    private CambioService service;

    @GetMapping("/{amount}/{from}/{to}")
    @Operation(summary = "Get cambio from currency")
    public ResponseEntity<Cambio> getCambio(@PathVariable BigDecimal amount,
                                            @PathVariable String from,
                                            @PathVariable String to) {

        var port = environment.getProperty("local.server.port");
        var cambio = service.findByFromAndTo(from, to);
        var convertedValue = cambio.getConversionFactor().multiply(amount);
        cambio.setConvertedValue(convertedValue.setScale(2, RoundingMode.CEILING));
        cambio.setEnvironment(port);
        return ResponseEntity.ok(cambio);
    }
}
