package com.example.practicav3.DB;

import com.example.practicav3.cuenta.Cuenta;
import org.springframework.stereotype.Repository;


import java.math.BigDecimal;
import java.util.List;

@Repository
public class CuentasDB {


    public static List<Cuenta> cuentas = List.of(
            new Cuenta("1", new BigDecimal("1000")),
            new Cuenta("2", new BigDecimal("2000")),
            new Cuenta("3", new BigDecimal("3000")),
            new Cuenta("4", new BigDecimal("4000")),
            new Cuenta("5", new BigDecimal("5000")) 
    );
}