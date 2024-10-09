package com.bancolombia.aplicacionbancaria.service;

import com.bancolombia.aplicacionbancaria.CuentaDb.CuentaDb;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
@Service
public class CuentaService {


    private final CuentaDb cuentaDb;
    private BigDecimal nuevoSaldo;
    private BigDecimal monto1;

    public CuentaService(CuentaDb cuentaDb) {
        this.cuentaDb = cuentaDb;
    }

    public BigDecimal obtenerSaldo(String cuenta){
        validaCuenta(cuenta);
        return CuentaDb.BuscarCuenta(cuenta).getSaldo();
    }

    public BigDecimal depositar(String cuenta, String monto){

        validaCuenta(cuenta);
        monto1 = new BigDecimal(monto);

        nuevoSaldo = cuentaDb.BuscarCuenta(cuenta).deposito(monto1);
        return nuevoSaldo;
    }

    public BigDecimal retirar(String cuenta, String monto){

        validaCuenta(cuenta);

        monto1 = new BigDecimal(monto);
        if(monto1.compareTo(CuentaDb.BuscarCuenta(cuenta).getSaldo()) > 0 ){
            throw new IllegalArgumentException("Saldo insuficiente");
        }

        nuevoSaldo = cuentaDb.BuscarCuenta(cuenta).retiro(monto1);
        return nuevoSaldo;
    }

    public String validaCuenta(String cuenta){
        if (CuentaDb.BuscarCuenta(cuenta) == null){
            throw new NullPointerException("Cuenta no existe");
        };
        return cuenta;
    }

}
