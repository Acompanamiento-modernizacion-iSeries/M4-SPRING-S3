package com.bancolombia.aplicacionbancaria.model;

import com.bancolombia.aplicacionbancaria.CuentaDb.CuentaDb;
import jakarta.validation.constraints.*;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;

//Estructura que se pretende recibir desde el cliente
@Validated
public class TransaccionDTO {
    private final CuentaDb cuentaDb;
    @NotBlank(message = "El campo no puede estar vacío.")
    @Pattern(regexp = "^(?!0$)\\d*(\\.\\d+)?$", message = "Solo se permiten números positivos.")
    private String monto;
    @NotBlank(message = "La descripción es obligatoria")
    private String descripcion;
    @NotNull(message = "El numero de cuenta es obligatorio")
    private String cuenta;
    private BigDecimal nuevoSaldo;
    private BigDecimal monto1;

    public TransaccionDTO(CuentaDb cuentaDb, String cuenta, String monto, String descripcion) {
        this.cuentaDb = cuentaDb;
        this.cuenta = cuenta;
        this.monto = monto;
        this.descripcion = descripcion;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    @Override
    public String
    toString() {
        return "TransaccionDTO{" +
                "monto=" + monto +
                ", descripcion='" + descripcion + '\'' +
                ", cuenta='" + cuenta + '\'' +
                '}';
    }
}
