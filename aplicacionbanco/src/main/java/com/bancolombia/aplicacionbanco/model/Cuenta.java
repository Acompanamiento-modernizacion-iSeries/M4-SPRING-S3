package com.bancolombia.aplicacionbanco.model;

import java.math.BigDecimal;

public class Cuenta {

    private BigDecimal saldo;
    private String id;

    public Cuenta(BigDecimal saldo, String id){
        this.saldo=saldo;
        this.id=id;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
