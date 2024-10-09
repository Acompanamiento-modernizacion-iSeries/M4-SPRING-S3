package co.bancolombia.aplicacionbancaria.model;

import java.math.BigDecimal;

public class CuentaBancaria {

    private String usuario;
    private String nroCuenta;
    private BigDecimal saldo;

    public CuentaBancaria (String usuario, String nroCuenta, BigDecimal saldo) {
        this.usuario = usuario;
        this.nroCuenta = nroCuenta;
        this.saldo = saldo;
    }

    public String consultarCuenta() {

        return nroCuenta;
    }

    public void asignarCuenta(String nroCuenta) {

        this.nroCuenta = nroCuenta;
    }

    public BigDecimal consultarSaldo() {

        return saldo;
    }

    public void asignarSaldo(BigDecimal saldo) {

        this.saldo = saldo;
    }

    public String consultarUsuario() {

        return usuario;
    }

    public void asignarUsuario(String usuario) {

        this.usuario = usuario;
    }

    public void deposito(BigDecimal monto) {
        saldo = saldo.add(monto);
    }

    public void retiro(BigDecimal monto) {
        saldo = saldo.subtract(monto);
    }
}
