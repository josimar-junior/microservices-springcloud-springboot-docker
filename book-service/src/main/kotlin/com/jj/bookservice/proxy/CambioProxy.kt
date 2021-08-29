package com.jj.bookservice.proxy

import com.jj.bookservice.response.Cambio
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import java.math.BigDecimal

@FeignClient(name = "cambio-service")
interface CambioProxy {

    @GetMapping("/cambio-service/{amount}/{from}/{to}")
    fun getCambio(
        @PathVariable amount: Double?,
        @PathVariable from: String,
        @PathVariable to: String
    ): Cambio
}