package com.banco.taller2.Controller;
import com.banco.taller2.Model.TransaccionDTO;
import com.banco.taller2.Service.CuentaService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.math.BigDecimal;

@RestController
@RequestMapping("/cuenta")

public class CuentaController {

    private final CuentaService cuentaService;

    public CuentaController(CuentaService cuentaService){
        this.cuentaService = cuentaService;
    }

    @GetMapping("/saldo/{numeroCuenta}")
    public BigDecimal obtenerSaldo(@PathVariable String numeroCuenta){
        return cuentaService.obtenerSaldo(numeroCuenta);
    }


    @PostMapping("/deposito")
    public String depositar(@Valid @RequestBody TransaccionDTO transaccionDTO){
        cuentaService.depositar(transaccionDTO.getCuentaId(), transaccionDTO.getMonto());
        System.out.println(transaccionDTO.toString());
        return "Depósito existoso. su saldo actual es de: $" + cuentaService.obtenerSaldo(transaccionDTO.getCuentaId());
    }

    @PostMapping("/retiro")
    public String retirar(@Valid @RequestBody TransaccionDTO transaccionDTO) {
        cuentaService.retirar(transaccionDTO.getCuentaId(), transaccionDTO.getMonto());
        return "Retiro exitoso. Saldo actual: " + cuentaService.obtenerSaldo(transaccionDTO.getCuentaId());
    }


}


