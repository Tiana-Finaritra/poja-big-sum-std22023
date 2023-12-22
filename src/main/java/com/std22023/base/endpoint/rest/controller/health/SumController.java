package com.std22023.base.endpoint.rest.controller.health;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
public class SumController {

    @GetMapping("/big-sum")
    public String bigSum(@RequestParam("a") String a, @RequestParam("b") String b) {
        try {
            BigInteger numA = new BigInteger(a);
            BigInteger numB = new BigInteger(b);

            BigInteger sum = numA.add(numB);

            return "{\"sum\": \"" + sum.toString() + "\"}";
        } catch (NumberFormatException e) {
            return "{\"error\": \"Veuillez fournir des nombres valides.\"}";
        }
    }
}
