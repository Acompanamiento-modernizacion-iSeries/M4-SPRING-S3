package co.bancolombia.aplicacionbancaria.controller;

import co.bancolombia.aplicacionbancaria.controller.helper.Interceptor;
import co.bancolombia.aplicacionbancaria.service.CuentaService;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;


    @GetMapping("/saldo/{numeroCuenta}")
    public ResponseEntity<BigDecimal> obtenerSaldo(@PathVariable(name = "numeroCuenta")@NotNull(message = "El numero de la cuenta es obligatorio") String numeroCuenta) {
        if(cuentaService.obtenerSaldo(numeroCuenta) == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return ResponseEntity.ok().body(cuentaService.obtenerSaldo(numeroCuenta));
    }

    @PostMapping("/deposito/{numeroCuenta}")
    public ResponseEntity<String> depositar(@PathVariable(name = "numeroCuenta")@NotNull(message = "El numero de la cuenta es obligatorio") String numeroCuenta,
                                            @RequestParam(name = "monto")@Min(1) BigDecimal monto) {
        cuentaService.depositar(numeroCuenta, monto);
        return ResponseEntity.ok("Depósito realizado exitosamente.");
    }

    @PostMapping("/retiro/{numeroCuenta}")
    public ResponseEntity<String> retirar(@PathVariable(name ="numeroCuenta")@NotNull(message = "El numero de la cuenta es obligatorio") String numeroCuenta,
                                          @RequestParam(name = "monto")@Min(1) BigDecimal monto) {
        if (cuentaService.retirar(numeroCuenta, monto)) {
            return ResponseEntity.ok("Retiro realizado exitosamente.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Saldo insuficiente.");
        }
    }

    @ExceptionHandler({IllegalArgumentException.class, ConstraintViolationException.class})
    public ResponseEntity<String> manejarExcepcion(IllegalArgumentException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
