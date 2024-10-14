package com.bancolombia.aplicacionbancaria.repository;



import com.bancolombia.aplicacionbancaria.cuentas.Cuenta;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CuentasDB {

    private static List<Cuenta> cuentaList = new ArrayList<Cuenta>(
            List.of(
                    new Cuenta(new BigDecimal(11001), "1"),
                    new Cuenta(new BigDecimal(12002), "2"),
                    new Cuenta(new BigDecimal(13003), "3"),
                    new Cuenta(new BigDecimal(14004), "4"),
                    new Cuenta(new BigDecimal(15005), "5"),
                    new Cuenta(new BigDecimal(16006), "6"),
                    new Cuenta(new BigDecimal(17007), "7"),
                    new Cuenta(new BigDecimal(18008), "8"),
                    new Cuenta(new BigDecimal(19009), "9"),
                    new Cuenta(new BigDecimal(12020), "10")
            )
    );

    public Cuenta getCuenta(String numeroCuenta) {
        for (Cuenta cuenta : cuentaList) {
            if (cuenta.getNumeroCuenta().equals(numeroCuenta)) {
                return cuenta;
            }
        }
        return null;
    };
}
