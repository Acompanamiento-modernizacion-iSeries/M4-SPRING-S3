package co.bancolombia.aplicacionbancaria.models.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class ConsultarSaldoDTO {
    @NotNull(message = "Número de cuenta invalido")
    @NotEmpty(message = "Número de cuenta vacio")
    private String idCuenta;

    public ConsultarSaldoDTO(String idCuenta) {
        this.idCuenta = idCuenta;

    }
    public String getIdCuenta() {
        return idCuenta;
    }
    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
    }
}
