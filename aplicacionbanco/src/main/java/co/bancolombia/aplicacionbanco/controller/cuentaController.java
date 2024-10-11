package co.bancolombia.aplicacionbanco.controller;

import co.bancolombia.aplicacionbanco.model.Cuenta;
import co.bancolombia.aplicacionbanco.model.TransaccionDTO;
import co.bancolombia.aplicacionbanco.service.cuentaService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import jakarta.validation.Valid;


import java.math.BigDecimal;

@RestController
@RequestMapping("/numCuenta")
public class cuentaController {

    private final cuentaService cuentaservice;
    public cuentaController(cuentaService cuentaservice){
        this.cuentaservice = cuentaservice;
    }

    @GetMapping("/saldo/{numCuenta}")
    public String obtenerSaldo(@Valid @RequestBody Cuenta cuenta) {
        BigDecimal valSaldo = cuentaservice.obtenerSaldo(cuenta.getNumeroCuenta());
        return "El saldo de su cuenta es : " + valSaldo;
    }


    @PostMapping("/deposito/{numCuenta}")
    public String depositar(@Valid @RequestBody TransaccionDTO transaccion) {
        return cuentaservice.depositar(transaccion.getNumCuenta(), transaccion.getMonto());

    }


    @PostMapping("/retirar/{numCuenta}")
    public String retirar(@Valid @RequestBody TransaccionDTO transaccion){
        return cuentaservice.retirar(transaccion.getNumCuenta(), transaccion.getMonto());
    }
}




