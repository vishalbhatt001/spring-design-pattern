package com.spring.design.pattern.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyController {
    private final PaymentService paymentService;

    @Autowired
    public MyController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/purchase")
    public String purchase(@RequestParam String paymentMethod, @RequestParam double amount) {
        String result = paymentService.processPayment(paymentMethod, amount);
        return result;
    }
}
