package com.jj.cambioservice.service;

import com.jj.cambioservice.model.Cambio;
import com.jj.cambioservice.repository.CambioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CambioService {

    private CambioRepository repository;

    public CambioService(CambioRepository repository) {
        this.repository = repository;
    }

    public Cambio findByFromAndTo(String from, String to) {
        return repository.findByFromAndTo(from, to)
                .orElseThrow(() -> new RuntimeException("Currency unsupported"));
    }
}
