package co.com.bancolombia.aplicacionbancaria.controller;

import co.com.bancolombia.aplicacionbancaria.dto.CuentaDTO;
import co.com.bancolombia.aplicacionbancaria.dto.TransaccionDTO;
import co.com.bancolombia.aplicacionbancaria.service.CuentaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {

    private final CuentaService CUENTA_SERVICE;

    public CuentaController(CuentaService cuentaService) {
        this.CUENTA_SERVICE = cuentaService;
    }

    @GetMapping("/saldo")
    public String saldo(@Valid @RequestBody CuentaDTO cuenta) {
        return "Su saldo actual es $"
                + CUENTA_SERVICE.consultarSaldo(cuenta);
    }

    @PostMapping("/deposito")
    public String deposito(@Valid @RequestBody TransaccionDTO transaccion) {
        return "Deposito realizado con éxito! "
                + "- Nuevo saldo: $" + CUENTA_SERVICE.deposito(transaccion);
    }

    @PostMapping("/retiro")
    public String retiro(@Valid @RequestBody TransaccionDTO transaccion) {
        return "Retiro realizado con éxito! "
                + "- Nuevo saldo: $" + CUENTA_SERVICE.retiro(transaccion);
    }
}
