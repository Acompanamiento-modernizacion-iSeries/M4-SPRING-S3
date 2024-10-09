package com.bancolombia.aplicacionbancaria.model;

import com.bancolombia.aplicacionbancaria.CuentaDb.CuentaDb;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.math.BigDecimal;

public class ConsultaDTO {
    private final CuentaDb cuentaDb;
   @NotNull(message = "El numero de cuenta es obligatorio")
    private String cuenta;
    private BigDecimal nuevoSaldo;
    private BigDecimal monto1;

    public ConsultaDTO(CuentaDb cuentaDb, String cuenta) {
        this.cuentaDb = cuentaDb;
        this.cuenta = cuenta;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public String toString() {
        return "ConsultaDTO{" +
                "cuenta='" + cuenta + '\'' +
                '}';
    }
}
