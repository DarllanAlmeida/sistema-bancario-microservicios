package com.banco.cuenta_service.controller;


import com.banco.cuenta_service.entities.Cuenta;
import com.banco.cuenta_service.service.CuentaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {

    private final CuentaService cuentaService;

    public CuentaController(CuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    @PostMapping
    public ResponseEntity<Cuenta> crearCuenta(@RequestParam String titular) {
        Cuenta cuenta = cuentaService.crearCuenta(titular);
        return ResponseEntity.ok(cuenta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cuenta> obtenerCuenta(@PathVariable Long id) {
        return cuentaService.obtenerCuenta(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}/depositar")
    public ResponseEntity<Cuenta> depositar(@PathVariable Long id, @RequestParam Double monto) {
        try {
            Cuenta cuenta = cuentaService.depositar(id, monto);
            return ResponseEntity.ok(cuenta);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/{id}/retirar")
    public ResponseEntity<Cuenta> retirar(@PathVariable Long id, @RequestParam Double monto) {
        try {
            Cuenta cuenta = cuentaService.retirar(id, monto);
            return ResponseEntity.ok(cuenta);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
