package co.bancolombia.aplicacionbancaria.repository;

import co.bancolombia.aplicacionbancaria.model.CuentaBancaria;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CuentaBancariaBD {

    private static List<CuentaBancaria> cuentas  = new ArrayList<>();

    public CuentaBancariaBD(){
        cuentas.add(new CuentaBancaria("012345", new BigDecimal("4000000")));
        cuentas.add(new CuentaBancaria("234567", new BigDecimal("3000000")));
        cuentas.add(new CuentaBancaria("456789", new BigDecimal("2000000")));
        cuentas.add(new CuentaBancaria("678901", new BigDecimal("1000000")));
        cuentas.add(new CuentaBancaria("890123", new BigDecimal("500000")));
    }


    public static CuentaBancaria buscarCuenta(String nroCuenta) {
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.consultarCuenta().equals(nroCuenta)) {
                return cuenta;
            }
        }
        return null;
    }

}
