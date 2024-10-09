package com.bancolombia.aplicacionbancaria.controller;

import com.bancolombia.aplicacionbancaria.CuentaDb.CuentaDb;
import com.bancolombia.aplicacionbancaria.model.ConsultaDTO;
import com.bancolombia.aplicacionbancaria.model.TransaccionDTO;
import com.bancolombia.aplicacionbancaria.service.CuentaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {

   private final CuentaService cuentaService;
    private BigDecimal nuevoSaldo;


    public CuentaController(CuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }
    // private CuentaDb cuentaDb = new CuentaDb();

    @GetMapping("/saldo")
    public String obtenerSaldo(@Valid @RequestBody ConsultaDTO consulta){
        BigDecimal saldo = cuentaService.obtenerSaldo(consulta.getCuenta());
        return "El saldo actual es: " + saldo;
    }

    //recibir un body desde el create esto es tipo JSON
    @PostMapping("/deposito")
    public String DepositarSaldo(@Valid @RequestBody TransaccionDTO transaccion){
        nuevoSaldo = cuentaService.depositar(transaccion.getCuenta(), transaccion.getMonto());
        System.out.println(transaccion.toString());
        return "Deposito exitoso, saldo actual: " + nuevoSaldo ;
    }

    @PostMapping("/retiro")
    public String RetiroSaldo(@Valid @RequestBody TransaccionDTO transaccion){
        nuevoSaldo = cuentaService.retirar(transaccion.getCuenta(),transaccion.getMonto());
        System.out.println(transaccion.toString());
        return "Retiro exitoso, saldo actual: " + nuevoSaldo;
    }
}
