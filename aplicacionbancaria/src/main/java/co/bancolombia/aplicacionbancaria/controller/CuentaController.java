package co.bancolombia.aplicacionbancaria.controller;

import co.bancolombia.aplicacionbancaria.db.DBCuenta;
import co.bancolombia.aplicacionbancaria.modelo.ConsultaSaldoDTO;
import co.bancolombia.aplicacionbancaria.modelo.CuentaBanco;
import co.bancolombia.aplicacionbancaria.modelo.TransaccionDTO;
import co.bancolombia.aplicacionbancaria.service.CuentaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {
    private final CuentaService cuentaService;

    CuentaController(CuentaService cuentaService){
        this.cuentaService = cuentaService;
    }

    @GetMapping("/saldo")
    public String consultarSaldo(@Valid @RequestBody ConsultaSaldoDTO consultaSaldoDTO) {
        return cuentaService.consultarSaldo(consultaSaldoDTO.getIdCuenta());
    }
    @PostMapping("/deposito")
    public String depositar(@Valid @RequestBody TransaccionDTO transaccionDTO) {
       return cuentaService.depositar(transaccionDTO);
    }
    @PostMapping("/retiro")
    public String retirar(@Valid @RequestBody TransaccionDTO transaccionDTO) {
        return cuentaService.retirar(transaccionDTO);
    }
}
