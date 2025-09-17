package com.banco.transacciones_service.repository;

import com.banco.transacciones_service.entities.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransaccionRepository extends JpaRepository<Transaccion, Long> {
    List<Transaccion> findByCuentaId(Long cuentaId);
}
