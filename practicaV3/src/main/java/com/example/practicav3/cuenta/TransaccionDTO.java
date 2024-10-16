package com.example.practicav3.cuenta;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;


public class TransaccionDTO {

    @NotNull(message = "El número de cuenta no puede ser nulo")
    private String numeroCuenta;

    @NotNull(message = "El monto no puede ser nulo")
    @Min(value = 1, message = "El monto debe ser mayor o igual a 1")
    private BigDecimal monto;

    // Getters y setters
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }
}
