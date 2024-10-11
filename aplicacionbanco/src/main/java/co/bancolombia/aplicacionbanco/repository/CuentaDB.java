package co.bancolombia.aplicacionbanco.repository;
import co.bancolombia.aplicacionbanco.model.Cuenta;

import org.springframework.stereotype.Repository;
import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class CuentaDB {
    private List<Cuenta> cuentas;

    public CuentaDB() {
        this.cuentas = Arrays.asList(
                new Cuenta("cta123", new BigDecimal(1000.00)),
                new Cuenta("cta456", new BigDecimal(2000.00)),
                new Cuenta("cta789", new BigDecimal(1500.00))
        );
    }


    public Cuenta buscarPorCuenta(String cuenta){
        return cuentas.stream().filter(p ->  p.getNumeroCuenta().equals(cuenta)).findFirst().orElse(null);

        }

    }


