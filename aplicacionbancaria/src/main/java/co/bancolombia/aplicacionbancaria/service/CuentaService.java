package co.bancolombia.aplicacionbancaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.bancolombia.aplicacionbancaria.DB.DB;
import co.bancolombia.aplicacionbancaria.Cuenta.Cuenta;

import java.math.BigDecimal;

@Service
public class CuentaService {

    private Cuenta cuentaEncontrada = null;
    @Autowired
    private DB DB;
    public String obtenerSaldo(String cuenta) {
        cuentaEncontrada = DB.getCuenta(Integer.parseInt(cuenta));
        if(cuentaEncontrada == null){
            throw new NullPointerException("La cuenta no existe, intente con otro número de cuenta.");
        }
        return "El saldo de la cuenta que consulto es: " + cuentaEncontrada.obtenerSaldo();
    }

    public String depositar(String cuenta, BigDecimal monto) {
        cuentaEncontrada = DB.getCuenta(Integer.parseInt(cuenta));
        if(cuentaEncontrada == null){
            throw new NullPointerException("La cuenta no existe, intente con otro número de cuenta.");
        }
        if(monto.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("El monto a retirar no debe ser menor a cero");
        }else{
            cuentaEncontrada.deposito(monto);
        }
        return "El saldo actual es: " + cuentaEncontrada.obtenerSaldo();
    }

    public String retirar(BigDecimal monto, Integer cuenta) {
        cuentaEncontrada = DB.getCuenta(cuenta);
        if(cuentaEncontrada == null){
            throw new NullPointerException("La cuenta no existe, intente con otro número de cuenta.");
        }
        if(monto.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("El monto a retirar no debe ser menor a cero");
        }
        if(cuentaEncontrada.obtenerSaldo().compareTo(monto) < 0){
            throw new IllegalStateException("Saldo insuficiente para realizar esta transacción.");
        }
        cuentaEncontrada.retiro(monto);
        return "El saldo luego del retiro es : " + cuentaEncontrada.obtenerSaldo();
    }
}
