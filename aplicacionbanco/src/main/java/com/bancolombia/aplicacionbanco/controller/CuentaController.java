package com.bancolombia.aplicacionbanco.controller;

import com.bancolombia.aplicacionbanco.repository.CuentaRepository;
import com.bancolombia.aplicacionbanco.service.CuentaService;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {

    private final CuentaService cuentaService;
    private final CuentaRepository cuentaRepository;

    public CuentaController(CuentaService cuentaService, CuentaRepository cuentaRepository) {
        this.cuentaService = cuentaService;
        this.cuentaRepository=cuentaRepository;
    }

    @GetMapping("/saldo")
    public BigDecimal obtenerSaldo(){
        return cuentaService.obtenerSaldo();
    }

    @PostMapping("/deposito")
    public String deposito(@Valid @RequestBody TransaccionDTO transaccionDto){
        System.out.println(transaccionDto.toString());
        boolean indCuenta = cuentaRepository.buscarCuenta(transaccionDto.getCuentaId());
        if (indCuenta){
            BigDecimal nuevoSaldo = cuentaService.depositar(transaccionDto.getMonto());
            return "Deposito exitoso en la cuenta: "+transaccionDto.getCuentaId()+"\nSaldo actual: "+nuevoSaldo;
        }else{
            return "No existe el numero de cuenta ingresado: "+transaccionDto.getCuentaId();
        }

    }

    @PostMapping("/retiro")
    public String retiro(@Valid @RequestBody TransaccionDTO transaccionDto) {
        System.out.println(transaccionDto.toString());
        boolean indCuenta = cuentaRepository.buscarCuenta(transaccionDto.getCuentaId());
        if (indCuenta){
            BigDecimal nuevoSaldo = cuentaService.retirar(transaccionDto.getMonto());
            return "Retiro exitoso de la cuenta: "+transaccionDto.getCuentaId()+"\nNuevo saldo: "+nuevoSaldo;
        } else{
            return "No existe el numero de cuenta ingresado: "+transaccionDto.getCuentaId();
        }

    }

    @PostMapping("/buscarCuenta")
    public String obtenerCuenta(@RequestBody String cuenta){
        boolean indCuenta = cuentaRepository.buscarCuenta(cuenta);
        if(indCuenta){
            return "número de cuenta existente! " +cuenta;
        }else{
            return "No existe número de cuenta ingresado: " +cuenta;
        }
    }
}
