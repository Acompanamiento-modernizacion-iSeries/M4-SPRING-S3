package co.com.bancolombia.aplicacionbancaria.controller;


import co.com.bancolombia.aplicacionbancaria.model.TransaccionDTO;
import co.com.bancolombia.aplicacionbancaria.service.CuentaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {
    private final CuentaService cuentaService;

    public CuentaController(CuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    @GetMapping("/{numeroCuenta}/saldo")
    public BigDecimal saldo(@PathVariable String numeroCuenta) {
        return cuentaService.obtenerSaldo(numeroCuenta);
    }

    @PostMapping("/deposito")
    public String depositar(@Valid @RequestBody TransaccionDTO transaccion) {

        return cuentaService.depositar(transaccion.getCuenta(),transaccion.getMonto());
    }

    @PostMapping("/{numeroCuenta}/retiro")
    public String retirar(@PathVariable String numeroCuenta, @RequestParam BigDecimal monto) {
        return cuentaService.retirar(numeroCuenta, monto);
    }
}