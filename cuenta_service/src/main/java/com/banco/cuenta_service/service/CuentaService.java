package com.banco.cuenta_service.service;

import com.banco.cuenta_service.entities.Cuenta;
import com.banco.cuenta_service.repository.CuentaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CuentaService {

    private final CuentaRepository cuentaRepository;

    public CuentaService(CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    public Cuenta crearCuenta(String titular) {
        Cuenta cuenta = new Cuenta();
        cuenta.setTitular(titular);
        cuenta.setSaldo(0.0);
        return cuentaRepository.save(cuenta);
    }

    public Optional<Cuenta> obtenerCuenta(Long id) {
        return cuentaRepository.findById(id);

    }

    public Cuenta depositar(Long id, Double monto) {
        Cuenta cuenta = cuentaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));
        cuenta.setSaldo(cuenta.getSaldo() + monto);
        return cuentaRepository.save(cuenta);
    }

    public Cuenta retirar(Long id, Double monto) {
        Cuenta cuenta = cuentaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));
        if (cuenta.getSaldo() < monto) {
            throw new RuntimeException("Saldo insuficiente");
        }
        cuenta.setSaldo(cuenta.getSaldo() - monto);
        return cuentaRepository.save(cuenta);
    }
}
