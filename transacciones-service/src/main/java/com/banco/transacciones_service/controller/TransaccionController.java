package com.banco.transacciones_service.controller;

import com.banco.transacciones_service.entities.Transaccion;
import com.banco.transacciones_service.service.TransaccionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacciones")
public class TransaccionController {

    private final TransaccionService transaccionService;

    public TransaccionController(TransaccionService transaccionService) {
        this.transaccionService = transaccionService;
    }

    @PostMapping("/depositar")
    public ResponseEntity<Transaccion> depositar(@RequestParam Long cuentaId, @RequestParam Double monto){
        try{
            Transaccion transaccion = transaccionService.depositar(cuentaId, monto);
            return ResponseEntity.ok(transaccion);
        }catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @PostMapping("/retirar")
    public ResponseEntity<Transaccion> retirar(@RequestParam Long cuentaId, @RequestParam Double monto){
        try{
            Transaccion transaccion = transaccionService.retirar(cuentaId, monto);
            return ResponseEntity.ok(transaccion);
        } catch (RuntimeException e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/historial/{cuentaId}")
    public ResponseEntity<List<Transaccion>> historial(@PathVariable Long cuentaId) {
        List<Transaccion> transacciones = transaccionService.historial(cuentaId);
        return ResponseEntity.ok(transacciones);
    }
}
