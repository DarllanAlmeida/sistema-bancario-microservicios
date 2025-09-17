package com.banco.transacciones_service.client;

import com.banco.transacciones_service.dto.CuentaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@FeignClient(name = "cuenta-service", url = "http://localhost:8081/cuentas")
public interface CuentaClient {

    @GetMapping("/{id}")
    Optional<CuentaDTO> obtenerCuenta(@PathVariable Long id);

    @PostMapping("/{id}/depositar")
    CuentaDTO depositar(@PathVariable Long id, @RequestParam Double monto);

    @PostMapping("/{id}/retirar")
    CuentaDTO retirar(@PathVariable Long id, @RequestParam Double monto);
}
