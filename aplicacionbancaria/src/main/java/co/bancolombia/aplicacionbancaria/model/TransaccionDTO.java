package co.bancolombia.aplicacionbancaria.model;


import jakarta.validation.constraints.*;

import java.math.BigDecimal;


public class TransaccionDTO {
    @NotEmpty(message = "El número de cuenta es obligatorio!")
    @Size(max = 10, message = "El número de cuenta no puede tener más de 10 caracteres!")
    private String nroCuenta;

    @NotNull(message = "El monto de la transacción es obligatorio!")
    @Positive(message = "El monto de la transacción debe ser mayor a cero!")
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