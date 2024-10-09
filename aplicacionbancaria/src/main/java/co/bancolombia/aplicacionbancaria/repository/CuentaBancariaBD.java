package co.bancolombia.aplicacionbancaria.repository;

import co.bancolombia.aplicacionbancaria.model.CuentaBancaria;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CuentaBancariaBD {

    private static List<CuentaBancaria> cuentas  = new ArrayList<>();

    //Constructor que inicializa listado de cuentas en memoria.
    public CuentaBancariaBD(){
        cuentas.add(new CuentaBancaria("Juan Pablo Valderrama","1128935712", new BigDecimal("1200000")));
        cuentas.add(new CuentaBancaria("Manuela Salazar","8776521123", new BigDecimal("2000000")));
        cuentas.add(new CuentaBancaria("Diana Maria Ochoa","9872123998", new BigDecimal("3000000")));
        cuentas.add(new CuentaBancaria("Samuel Suaza","1276311863", new BigDecimal("200000")));
        cuentas.add(new CuentaBancaria("Camila Velez","9864123123", new BigDecimal("10000")));
    }

    //Buscar cuenta por número de cuenta.
    public static CuentaBancaria buscarCuenta(String nroCuenta) {
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.consultarCuenta().equals(nroCuenta)) {
                return cuenta;
            }
        }
        return null;
    }

}
