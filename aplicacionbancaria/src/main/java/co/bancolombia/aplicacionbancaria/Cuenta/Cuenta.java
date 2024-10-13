package co.bancolombia.aplicacionbancaria.Cuenta;

import java.math.BigDecimal;

public class Cuenta {

    private BigDecimal saldoCuenta;
    private Integer numeroCuenta;

    public Cuenta(BigDecimal saldo, Integer numeroCuenta) {
        this.saldoCuenta = saldo;
        this.numeroCuenta = numeroCuenta;
    }

    public BigDecimal obtenerSaldo() {
        return saldoCuenta;
    };

    public void setSaldo(BigDecimal saldo) {
        this.saldoCuenta = saldo;
    };

    public Integer getNumeroCuenta() {
        return numeroCuenta;
    };

    public void retiro(BigDecimal monto){
        BigDecimal saldo = obtenerSaldo();
        saldo = saldo.subtract(monto);
        setSaldo(saldo);
    };


    public void deposito(BigDecimal monto) {
        BigDecimal saldo = obtenerSaldo();
        saldo = saldo.add(monto);
        setSaldo(saldo);
    }
}