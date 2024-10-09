package co.bancolombia.aplicacionbancaria.service;

import co.bancolombia.aplicacionbancaria.model.CuentaBancaria;
import co.bancolombia.aplicacionbancaria.repository.CuentaBancariaBD;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CuentaService {

    private final CuentaBancariaBD CuentaBancariaBD;

    public CuentaService(CuentaBancariaBD CuentaBancariaBD) {
        this.CuentaBancariaBD = CuentaBancariaBD;
    }

    public String obtenerSaldo(String nroCuenta) {
        CuentaBancaria cuenta = buscaCuenta(nroCuenta);
        return "Hola!, "+cuenta.consultarUsuario()+", El saldo de tu cuenta número: " +nroCuenta+ " es: $" +cuenta.consultarSaldo();
    }

    public String depositar(String nroCuenta, BigDecimal monto) {
        CuentaBancaria cuenta = buscaCuenta(nroCuenta);
        cuenta.deposito(monto);
        return "¡Depósito exitoso! sobre cuenta número: " + nroCuenta + " Nuevo saldo: $" + cuenta.consultarSaldo();
    }

    public String retirar(String nroCuenta, BigDecimal monto) {
        CuentaBancaria cuenta = buscaCuenta(nroCuenta);
        if (cuenta.consultarSaldo().compareTo(monto) < 0) {
            throw new IllegalArgumentException("¡Saldo insuficiente para realizar retiro!");
        }
        cuenta.retiro(monto);
        return "¡Retiro exitoso! "+ "sobre cuenta número: "+nroCuenta+" Nuevo saldo: $" + cuenta.consultarSaldo();

    }

    private CuentaBancaria buscaCuenta(String nroCuenta) {
        CuentaBancaria cuenta = CuentaBancariaBD.buscarCuenta(nroCuenta);
        if (cuenta == null) {
            throw new NullPointerException("¡La cuenta consultada no existe!");
        }
        return cuenta;
    }


}
