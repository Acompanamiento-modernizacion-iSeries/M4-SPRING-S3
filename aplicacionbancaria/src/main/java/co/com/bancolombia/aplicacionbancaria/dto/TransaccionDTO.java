package co.com.bancolombia.aplicacionbancaria.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public class TransaccionDTO {

    @NotEmpty(message = "Debe ingresar un número de cuenta")
    protected String cuenta;

    @NotEmpty(message = "Debe ingresar un monto de transacción válido")
    @DecimalMin(message = "Debe ingresar un monto mayor o igual a $0.01", value = "0.01", inclusive = true)
    protected String monto;

    @NotEmpty(message = "Ingrese una descripción")
    protected String descripcion;

    public TransaccionDTO(String cuenta, String monto, String descripcion) {
        this.cuenta = cuenta;
        this.monto = monto;
        this.descripcion = descripcion;
    }

    public String cuenta() {
        return cuenta;
    }

    public BigDecimal monto() {
        return new BigDecimal(monto);
    }
}
