package co.bancolombia.aplicacionbancaria.model;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class TransaccionDTO {

    @NotEmpty(message = "El número de cuenta obligatorio")
    private String nroCuenta;

    @Positive(message = "El monto de la transacción debe ser mayor a cero")
    @NotNull(message = "El monto de la transacción obligatorio")
    @Digits(integer = 15, fraction = 0, message = "El monto debe ser un número válido con hasta 15 dígitos enteros")
    private BigDecimal monto;

    public TransaccionDTO(String nroCuenta, BigDecimal monto) {
        this.nroCuenta = nroCuenta;
        this.monto = monto;
    }

    public String consultarCuenta() {
        return nroCuenta;
    }

    public void asignarCuenta(String nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    public BigDecimal consultarMonto() {
        return monto;
    }

    public void asignarMonto(BigDecimal monto) {
        this.monto = monto;
    }
}
