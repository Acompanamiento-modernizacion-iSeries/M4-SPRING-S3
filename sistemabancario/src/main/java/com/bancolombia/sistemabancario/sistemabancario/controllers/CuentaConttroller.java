package com.bancolombia.sistemabancario.sistemabancario.controllers;


import java.math.BigDecimal;
import java.util.List;

import com.bancolombia.sistemabancario.sistemabancario.models.ConsultaSaldoDTO;
import com.bancolombia.sistemabancario.sistemabancario.models.TransaccionDTO;
import com.bancolombia.sistemabancario.sistemabancario.services.CuentaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import com.bancolombia.sistemabancario.sistemabancario.models.Cuenta;


@RestController
@RequestMapping("/cuenta")
public class CuentaConttroller {

    private CuentaService cuentaService;
    public CuentaConttroller(CuentaService cuentaService){
        this.cuentaService = cuentaService;
    }

    @GetMapping("/listar")
    public List<Cuenta> listarCuentas() {
        List<Cuenta> listacuentas = cuentaService.listarCuentas();
        return listacuentas;
    }


    @GetMapping("/saldo")
    public String saldo(@Valid @RequestBody ConsultaSaldoDTO consultaCuenta) {
        Cuenta cuenta = cuentaService.BuscarPorCuenta(consultaCuenta.getIdCuenta());
        return  "El saldo de la cuenta es de: " + cuenta.getSaldo();
    }


    @PostMapping("/deposito")
    public String deposito(@Valid @RequestBody TransaccionDTO transaccion) {
        BigDecimal saldoActual = cuentaService.deposito(transaccion.getIdCuenta(), transaccion.getMonto());
        return "Depósito exitoso, El saldo actual de su cuenta es de :" + saldoActual;
    }


    @PostMapping("/retiro")
    public String retiro(@Valid @RequestBody TransaccionDTO transaccion) {
        BigDecimal saldoActual = cuentaService.retiro(transaccion.getIdCuenta(), transaccion.getMonto());
        return "retiro exitoso, El saldo actual de su cuenta es de :" + saldoActual;
    }
    
}
