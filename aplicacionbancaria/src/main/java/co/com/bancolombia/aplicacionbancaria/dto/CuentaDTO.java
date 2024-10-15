package co.com.bancolombia.aplicacionbancaria.dto;

import jakarta.validation.constraints.NotEmpty;

public class CuentaDTO {

    @NotEmpty(message = "Debe ingresar un número de cuenta")
    protected String cuenta;

    protected String descripcion;

    public CuentaDTO(String cuenta, String descripcion) {
        this.cuenta = cuenta;
        this.descripcion = descripcion == null ? "Consulta Informacion de Cuenta" : descripcion;
    }

    public String cuenta() {
        return cuenta;
    }
}
