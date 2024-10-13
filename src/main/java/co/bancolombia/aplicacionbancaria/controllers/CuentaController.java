package co.bancolombia.aplicacionbancaria.controllers;

import java.math.BigDecimal;
        import java.util.List;

import co.bancolombia.aplicacionbancaria.models.dto.ConsultarSaldoDTO;
import co.bancolombia.aplicacionbancaria.models.dto.LogTransaccionesDTO;
import co.bancolombia.aplicacionbancaria.services.CuentaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import co.bancolombia.aplicacionbancaria.models.Cuenta;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {
    private CuentaService cuentaService;
    public CuentaController(CuentaService cuentaService){
        this.cuentaService = cuentaService;
    }

    @GetMapping("/saldo")
    public String saldo(@Valid @RequestBody ConsultarSaldoDTO consultaCuenta) {
        Cuenta cuenta = cuentaService.BuscarIdCuenta(consultaCuenta.getIdCuenta());
        return "Cuenta : " + cuenta.getCuenta() + " \nSaldo  : " + cuenta.getSaldo();

    }
    @PostMapping("/deposito")
    public String deposito(@Valid @RequestBody LogTransaccionesDTO transaccion) {
        BigDecimal nuevoSaldo = cuentaService.deposito(transaccion.getIdCuenta(), transaccion.getMonto());
        return "DEPOSITO EXITOSO!!! \n\nCuenta : " + transaccion.getIdCuenta() + " \nSaldo  : " + nuevoSaldo;
    }
   @PostMapping("/retiro")
    public String retiro(@Valid @RequestBody LogTransaccionesDTO transaccion) {
        BigDecimal nuevoSaldo = cuentaService.retiro(transaccion.getIdCuenta(), transaccion.getMonto());
        return "RETIRO EXITOSO!!! \n\nCuenta : " + transaccion.getIdCuenta() + " \nSaldo  : " + nuevoSaldo;
    }
    @GetMapping("/listar_cuentas")
    public List<Cuenta> listarCuentas() {
        List<Cuenta> listacuentas = cuentaService.listarCuentas();
        return listacuentas;
    }
}