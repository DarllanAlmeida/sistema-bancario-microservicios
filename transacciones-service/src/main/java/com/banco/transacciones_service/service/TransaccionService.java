package com.banco.transacciones_service.service;

import com.banco.transacciones_service.client.CuentaClient;
import com.banco.transacciones_service.entities.Transaccion;
import com.banco.transacciones_service.repository.TransaccionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransaccionService {

    private final TransaccionRepository transaccionRepository;
    private final CuentaClient cuentaClient;

    public TransaccionService(TransaccionRepository transaccionRepository, CuentaClient cuentaClient) {
        this.transaccionRepository = transaccionRepository;
        this.cuentaClient = cuentaClient;
    }

    public Transaccion depositar(Long cuentaId, Double monto){
        cuentaClient.obtenerCuenta(cuentaId)
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));

        cuentaClient.depositar(cuentaId, monto);

        Transaccion transaccion = new Transaccion();
        transaccion.setCuentaId(cuentaId);
        transaccion.setTipo("DEPOSITO");
        transaccion.setMonto(monto);

        return transaccionRepository.save(transaccion);
    }

    public Transaccion retirar(Long cuentaId, Double monto){
        cuentaClient.obtenerCuenta(cuentaId)
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));

        cuentaClient.retirar(cuentaId, monto);

        Transaccion transaccion = new Transaccion();
        transaccion.setCuentaId(cuentaId);
        transaccion.setTipo("RETIRO");
        transaccion.setMonto(monto);

        return transaccionRepository.save(transaccion);
    }

    public List<Transaccion> historial(Long cuentaId){
        return transaccionRepository.findByCuentaId(cuentaId);
    }


}
