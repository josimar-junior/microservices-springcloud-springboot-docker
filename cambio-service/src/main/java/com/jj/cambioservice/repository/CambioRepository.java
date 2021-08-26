package com.jj.cambioservice.repository;

import com.jj.cambioservice.model.Cambio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CambioRepository extends JpaRepository<Cambio, Long> {

    Optional<Cambio> findByFromAndTo(String from, String to);
}
