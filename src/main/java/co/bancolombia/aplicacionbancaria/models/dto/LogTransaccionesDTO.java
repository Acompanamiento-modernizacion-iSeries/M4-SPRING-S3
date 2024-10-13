package co.bancolombia.aplicacionbancaria.models.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class LogTransaccionesDTO {
    @NotNull(message = "Número de cuenta invalido")
    @NotEmpty(message = "Número de cuenta vacio")
    private String idCuenta;

    @NotNull(message = "Valor de la transacción invalido")
    @Positive(message = "Valor invalido. Debe ser superior a 0 (cero)")
    private BigDecimal monto;
    private String descripcionTransaccion;


    public LogTransaccionesDTO(String idCuenta, BigDecimal monto, String descripcionTransaccion) {
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