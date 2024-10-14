package com.bancolombia.aplicacionbancaria.controller;

import com.bancolombia.aplicacionbancaria.repository.model.CuentaDTO;
import com.bancolombia.aplicacionbancaria.repository.model.TransaccionDTO;
import com.bancolombia.aplicacionbancaria.service.CuentaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/cuenta")
public class CuentaController {

    private CuentaService cuentaService;

    public CuentaController(CuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    @PostMapping("/saldo")
    public String obtenerSaldo(@Valid @RequestBody CuentaDTO cuentaDTO){
        return cuentaService.obtenerSaldo(cuentaDTO.getCuenta());
    }

    @PostMapping("/deposito")
    public String depositar(@Valid @RequestBody TransaccionDTO transaccionDTO) {
        return cuentaService.depositar(transaccionDTO.getCuenta(), transaccionDTO.getMonto());
    }

    @PostMapping("/retiro")
    public String retirar(@Valid @RequestBody TransaccionDTO transaccionDTO) {
        return cuentaService.retirar(transaccionDTO.getMonto(), transaccionDTO.getCuenta());
    }

}
