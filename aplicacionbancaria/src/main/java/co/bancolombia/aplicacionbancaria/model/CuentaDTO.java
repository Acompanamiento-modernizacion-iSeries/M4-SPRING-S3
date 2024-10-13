package co.bancolombia.aplicacionbancaria.model;

import java.math.BigDecimal;

public class CuentaDTO {
    private String cuenta;
    private BigDecimal saldo;

    public CuentaDTO(String cuenta, BigDecimal saldo) {
        this.cuenta = cuenta;
        this.saldo = saldo;
    }

    public String getCuenta() {
        return cuenta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}

