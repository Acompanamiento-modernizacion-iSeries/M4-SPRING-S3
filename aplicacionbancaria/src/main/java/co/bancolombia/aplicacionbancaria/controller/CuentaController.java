package co.bancolombia.aplicacionbancaria.controller;

import co.bancolombia.aplicacionbancaria.model.TransaccionDTO;
import co.bancolombia.aplicacionbancaria.service.CuentaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {

    private final CuentaService cuentaService;

    public CuentaController(CuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    //Obtener saldo de una cuenta.
    @GetMapping("/saldo/{nroCuenta}")
    public String obtenerSaldo(@PathVariable String nroCuenta) {
        return cuentaService.obtenerSaldo(nroCuenta);
    }

    //Depositar a una cuenta .
    @PostMapping("/deposito")
    public String depositar(@Valid @RequestBody TransaccionDTO transaccion) {
        return cuentaService.depositar(transaccion.consultarCuenta(), transaccion.consultarMonto());
    }

    //Retirar de una cuenta.
    @PostMapping("/retiro")
    public String retirar(@Valid @RequestBody TransaccionDTO transaccion) {
        return cuentaService.retirar(transaccion.consultarCuenta(), transaccion.consultarMonto());
    }
}
