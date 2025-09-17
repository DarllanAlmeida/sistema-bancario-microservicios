package com.banco.cuenta_service.repository;

import com.banco.cuenta_service.entities.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
}
