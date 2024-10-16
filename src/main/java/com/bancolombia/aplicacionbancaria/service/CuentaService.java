package com.bancolombia.aplicacionbancaria.service;

import com.bancolombia.aplicacionbancaria.model.Cuenta;
import com.bancolombia.aplicacionbancaria.model.CuentaDTO;
import com.bancolombia.aplicacionbancaria.model.DepositoDTO;
import com.bancolombia.aplicacionbancaria.model.RetiroDTO;
import com.bancolombia.aplicacionbancaria.repository.CuentasDB;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CuentaService {

    private final CuentasDB cuentasDB;

    public CuentaService(CuentasDB cuentasDB) {
        this.cuentasDB = cuentasDB;
    }

    public BigDecimal obtenerSaldo(CuentaDTO cuentaDTO) {
        for (Cuenta cuenta : cuentasDB.cuentas) {
            if (cuenta.getNumeroCuenta().equals(cuentaDTO.getNumeroCuenta())) {
                return cuenta.getSaldo();
            }
        }
        throw new IllegalArgumentException("Cuenta no encontrada");
    }

    public BigDecimal depositar(DepositoDTO transactionDTO) {
        if (transactionDTO.getMonto().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto a depositar debe ser mayor a cero");
        }
        for (Cuenta cuenta : cuentasDB.cuentas) {
            if (cuenta.getNumeroCuenta().equals(transactionDTO.getNumeroCuenta())) {
                cuenta.setSaldo(cuenta.getSaldo().add(transactionDTO.getMonto()));
                return cuenta.getSaldo();
            }
        }
        throw new IllegalArgumentException("Cuenta no encontrada");
    }

    public BigDecimal retirar(RetiroDTO retiroDTO) {
        for (Cuenta cuenta : cuentasDB.cuentas) {
            if (cuenta.getNumeroCuenta().equals(retiroDTO.getNumeroCuenta())) {
                if (retiroDTO.getMonto().compareTo(cuenta.getSaldo()) > 0) {
                    throw new IllegalStateException("Saldo insuficiente para realizar el retiro");
                }
                cuenta.setSaldo(cuenta.getSaldo().subtract(retiroDTO.getMonto()));
                return cuenta.getSaldo();
            }
        }
        throw new IllegalArgumentException("Cuenta no encontrada");
    }


}
