package com.example.practicav3.controller;

import com.example.practicav3.cuenta.TransaccionDTO;
import com.example.practicav3.service.CuentaService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.math.BigDecimal;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {

    private final CuentaService cuentaService;

    public CuentaController(CuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    @GetMapping("/saldo/{numeroCuenta}")
    public ResponseEntity<BigDecimal> obtenerSaldo(@PathVariable @NotNull(message = "El número de cuenta no puede ser nulo") String numeroCuenta) {
        BigDecimal saldo = cuentaService.getSaldo(numeroCuenta);
        return ResponseEntity.ok(saldo);
    }

    @PostMapping("/deposito")
    public ResponseEntity<String> realizarDeposito(@Valid @RequestBody TransaccionDTO transaccionDTO) {
        cuentaService.deposito(transaccionDTO.getNumeroCuenta(), transaccionDTO.getMonto());
        return ResponseEntity.ok("Depósito exitoso");
    }

    @PostMapping("/retiro")
    public ResponseEntity<String> realizarRetiro(@Valid @RequestBody TransaccionDTO transaccionDTO) {
        cuentaService.retiro(transaccionDTO.getNumeroCuenta(), transaccionDTO.getMonto());
        return ResponseEntity.ok("Retiro exitoso");
    }
}