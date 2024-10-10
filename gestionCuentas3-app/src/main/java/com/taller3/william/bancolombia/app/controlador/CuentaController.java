package com.taller3.william.bancolombia.app.controlador;

import com.taller3.william.bancolombia.app.servicio.CuentaService;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {

    private final CuentaService cuentaService;

    // Aqui realizo la inyección de dependencias
    @Autowired
    public CuentaController(CuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    // Endpoint para consultar saldo
    @GetMapping("/saldo/{id}")
    public double consultarSaldo(@PathVariable Long id) {
        return cuentaService.consultarSaldo(id);
    }

    // Endpoint para realizar un depósito
    @PostMapping("/depositar/{id}")
    public ResponseEntity<String> depositar(
            @PathVariable Long id,
            @NotNull @Min(value = 1, message = "El monto debe ser mayor que 0") double monto) {
        cuentaService.depositar(id, monto);
        return ResponseEntity.ok("Depósito realizado con éxito.");
    }

    // Endpoint para realizar un retiro
    @PostMapping("/retirar/{id}")
    public String retirar(
            @PathVariable Long id,
            @RequestParam @NotNull @Min(value = 1, message = "El monto debe ser mayor que 0") double monto) {
        cuentaService.retirar(id, monto);
        return "Retiro realizado con éxito.";
    }
}

