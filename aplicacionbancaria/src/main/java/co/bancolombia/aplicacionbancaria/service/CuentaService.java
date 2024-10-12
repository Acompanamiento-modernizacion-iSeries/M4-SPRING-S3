package co.bancolombia.aplicacionbancaria.service;

import co.bancolombia.aplicacionbancaria.db.DBCuenta;
import co.bancolombia.aplicacionbancaria.modelo.CuentaBanco;
import co.bancolombia.aplicacionbancaria.modelo.TransaccionDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CuentaService {

    private final DBCuenta dbCuenta;

    public CuentaService(DBCuenta dbCuenta) {
        this.dbCuenta = dbCuenta;
    }


    public String consultarSaldo(String nroCuenta) {
        CuentaBanco cuenta = DBCuenta.buscarCuenta(nroCuenta);
        validarCuenta(cuenta);
        return "El saldo de la cuenta número: " +nroCuenta+ " es: $" +cuenta.getSaldo();
    }

    public String depositar(TransaccionDTO transaccionDTO) {
        CuentaBanco cuenta = DBCuenta.buscarCuenta(transaccionDTO.getIdCuenta());
        validarCuenta(cuenta);
        validarMonto(cuenta.getSaldo(), transaccionDTO.getMonto());
        cuenta.depositar(transaccionDTO.getMonto());
        return "¡Depósito exitoso! sobre cuenta número: " + transaccionDTO.getIdCuenta() + " Nuevo saldo: $" + cuenta.getSaldo();
    }

    public String retirar(TransaccionDTO transaccionDTO) {
        CuentaBanco cuenta = DBCuenta.buscarCuenta(transaccionDTO.getIdCuenta());
        validarCuenta(cuenta);
        validarMonto(cuenta.getSaldo(), transaccionDTO.getMonto());

        cuenta.retirar(transaccionDTO.getMonto());
        return "¡Retiro exitoso! "+ "sobre cuenta número: "+transaccionDTO.getIdCuenta()+" Nuevo saldo: $" + cuenta.getSaldo();
    }

    private void validarMonto(BigDecimal saldo, BigDecimal monto) {
        if (saldo.compareTo(monto) < 0) {
            throw new IllegalArgumentException("Saldo insuficiente para realizar retiro");
        }
    }

    private void validarCuenta(CuentaBanco cuenta){
        if (cuenta == null) {
            throw new NullPointerException("Cuenta no existe");
        }
    }


}
