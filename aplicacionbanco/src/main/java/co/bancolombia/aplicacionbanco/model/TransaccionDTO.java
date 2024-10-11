package co.bancolombia.aplicacionbanco.model;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


import java.math.BigDecimal;

public class TransaccionDTO {
    @NotNull(message = "El monto de la tranasaccion es obligatorio")
    @Positive(message = "El monto debe ser mayor a cero")
    private BigDecimal monto;
    @NotNull(message = "La descripcion de la transaccion es obligatoria")
    private String descripcion;
    @NotNull(message = "El numero de cuenta es obligatorio")
    @NotEmpty(message = "La cuenta no puede estar vacia")
    private String numCuenta;

    public TransaccionDTO(BigDecimal monto, String descripcion, String numCuenta) {
        this.monto = monto;
        this.descripcion = descripcion;
        this.numCuenta = numCuenta;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "TransaccionDTO{" +
                "monto=" + monto +
                ", descripcion='" + descripcion + '\'' +
                ", numCuenta='" + numCuenta + '\'' +
                '}';
    }
}
