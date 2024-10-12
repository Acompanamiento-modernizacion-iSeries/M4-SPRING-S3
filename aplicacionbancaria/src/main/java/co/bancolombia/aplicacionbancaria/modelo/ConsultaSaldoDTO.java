package co.bancolombia.aplicacionbancaria.modelo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public class ConsultaSaldoDTO {

    @NotEmpty(message = "La cuenta no puede estar vacia")
    @Pattern(regexp="^\\d+$", message = "La cuenta debe ser un valor numerico")
    private String idCuenta;

    public ConsultaSaldoDTO() {
    }

    public ConsultaSaldoDTO(String idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
    }
}
