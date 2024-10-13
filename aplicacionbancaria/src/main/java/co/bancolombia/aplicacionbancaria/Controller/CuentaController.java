package co.bancolombia.aplicacionbancaria.Controller;

import co.bancolombia.aplicacionbancaria.DB.DB;
import co.bancolombia.aplicacionbancaria.model.TransaccionDTO;
import co.bancolombia.aplicacionbancaria.service.CuentaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {

    private CuentaService cuentaService;

    public CuentaController(CuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    //Ejemplo de consumo: http://localhost:8080/cuenta/saldo?cuenta=123
    @GetMapping("/saldo")
    public String obtenerSaldo(@RequestParam String cuenta) {
        return cuentaService.obtenerSaldo(cuenta);
    }

    //Ejemplo de consumo: http://localhost:8080/cuenta/deposito Body {"cuenta":"123","monto":1000,"descripcion":"Deposito"}
    @PostMapping("/deposito")
    public String depositar(@Valid @RequestBody TransaccionDTO transaccionDTO) {
        return cuentaService.depositar(transaccionDTO.getCuenta(), transaccionDTO.getMonto());
    }

    //Ejemplo de consumo: http://localhost:8080/cuenta/retiro?monto=1000&cuenta=456
    @PostMapping("/retiro")
    public String retirar(@RequestParam BigDecimal  monto, @RequestParam String cuenta) {
        return cuentaService.retirar(monto, Integer.parseInt(cuenta));
    }

}