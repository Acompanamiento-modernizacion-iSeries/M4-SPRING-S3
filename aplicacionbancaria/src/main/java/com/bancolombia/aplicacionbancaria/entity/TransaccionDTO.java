package com.bancolombia.aplicacionbancaria.entity;


import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public class TransaccionDTO {

    @NotNull(message = "El ID de la cuenta no puede ser nulo")
    @Positive(message = "EL ID de la cuenta debe ser mayor a cero!")
    private Long cuentaId;

    @NotNull(message = "El monto de la transaccion es obligatoria")
    @Positive(message = "EL monto debe ser mayor a cero!")
    @Min(message = "El monto minimo a depositor/Retirar debe ser de 10.000", value = 10000L)
    @Max(message = "El monto maximo aceptable a depositor/Retirar debe ser hasta 1.000.000", value = 1000000L)
    private BigDecimal monto;

    @NotBlank(message = "La descripcion es obligatoria")
    @Size(min = 2, max = 30, message = "El tamaño de la descripcion debe estar entre 2 y 30 caracteres")
    private String descripcion;

    public TransaccionDTO(Long cuentaId, BigDecimal monto, String descripcion) {
        this.cuentaId = cuentaId;
        this.monto = monto;
        this.descripcion = descripcion;
    }

    public Long getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(Long cuentaId) {
        this.cuentaId = cuentaId;
    }

    public BigDecimal getMonto() {
        return monto;
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
}
