package co.bancolombia.aplicacionbancaria.modelo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class TransaccionDTO {
    @NotEmpty(message = "La cuenta no puede estar vacia")
    @Pattern(regexp="^\\d+$", message = "La cuenta debe ser un valor numerico")
    private String idCuenta;

    @NotNull(message = "Debe ingresar el monto de la transacción")
    @Positive(message = "El monto debe ser mayor a cero")
    private BigDecimal monto;
    private String descripcionTransaccion;


    public TransaccionDTO(String idCuenta, BigDecimal monto, String descripcionTransaccion) {
        this.idCuenta = idCuenta;
        this.monto = monto;
        this.descripcionTransaccion = descripcionTransaccion;
    }

    public String getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getDescripcionTransaccion() {
        return descripcionTransaccion;
    }

    public void setDescripcionTransaccion(String descripcionTransaccion) {
        this.descripcionTransaccion = descripcionTransaccion;
    }
}
