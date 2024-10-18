package com.example.numberconversion.controller;

import com.example.numberconversion.client.ProbandoCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
public class NumberConversionController {

    @Autowired
    private ProbandoCliente probandoCliente;

    @GetMapping("/convert")
    public String convertNumberToWords(@RequestParam("number") BigInteger number) {
        // Invocar el cliente SOAP con el número
        probandoCliente.testingMetodo(number); // Pasa el BigInteger directamente

        return "Consulta enviada, revisa los logs para la respuesta";
    }
}
