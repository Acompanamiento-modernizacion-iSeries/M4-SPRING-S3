package co.com.bancolombia.aplicacionbancaria.service;

import co.com.bancolombia.aplicacionbancaria.dto.CuentaDTO;
import co.com.bancolombia.aplicacionbancaria.dto.TransaccionDTO;
import co.com.bancolombia.aplicacionbancaria.model.Cuenta;
import co.com.bancolombia.aplicacionbancaria.repository.CuentasDB;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CuentaService {

    private final CuentasDB CUENTAS_DB;

    public CuentaService(CuentasDB cuentasDb) {
        this.CUENTAS_DB = cuentasDb;
    }

    public BigDecimal consultarSaldo(@Valid CuentaDTO cuentaDTO) {
        return buscarCuenta(cuentaDTO.cuenta()).saldo();
    }

    public BigDecimal deposito(TransaccionDTO transaccionDTO) {
        String numCuenta = transaccionDTO.cuenta();
        BigDecimal vlrTransacc = transaccionDTO.monto();

        BigDecimal nuevoSaldo = buscarCuenta(numCuenta).saldo().add(vlrTransacc);
        buscarCuenta(numCuenta).actualizarSaldo(nuevoSaldo);
        return nuevoSaldo;
    }

    public BigDecimal retiro(TransaccionDTO transaccionDTO) {
        String numCuenta = transaccionDTO.cuenta();
        BigDecimal vlrTransacc = transaccionDTO.monto();

        if (vlrTransacc.compareTo(buscarCuenta(numCuenta).saldo()) > 0)
            throw new IllegalArgumentException("No tiene fondos suficientes!");

        BigDecimal nuevoSaldo = buscarCuenta(numCuenta).saldo().subtract(vlrTransacc);
        buscarCuenta(numCuenta).actualizarSaldo(nuevoSaldo);
        return nuevoSaldo;
    }

    public Cuenta buscarCuenta(String numCuenta) {
        for (Cuenta cuenta : CUENTAS_DB.listaCuentas()) {
            if (cuenta.numeroCuenta().equals(numCuenta)) {
                return cuenta;
            }
        }
        throw new NullPointerException("No existe una cuenta con el número proporcionado");
    }
}
