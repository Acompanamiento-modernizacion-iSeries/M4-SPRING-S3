package co.bancolombia.aplicacionbancaria.DB;

import co.bancolombia.aplicacionbancaria.Cuenta.Cuenta;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DB {

    private static List<Cuenta> cuentas = new ArrayList<Cuenta>(
            List.of(
                    new Cuenta(new BigDecimal(5000), 123),
                    new Cuenta(new BigDecimal(5000), 456),
                    new Cuenta(new BigDecimal(5000), 789)
            )
    );

    public Cuenta getCuenta(Integer numeroCuenta) {
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getNumeroCuenta().equals(numeroCuenta)) {
                return cuenta;
            }
        }
        return null;
    };
}
