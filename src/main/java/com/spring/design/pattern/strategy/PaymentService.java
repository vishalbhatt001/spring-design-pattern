package com.spring.design.pattern.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PaymentService {
    private final Map<String, PaymentStrategy> paymentStrategies;


    @Autowired
    public PaymentService(Map<String, PaymentStrategy> paymentStrategies) {
        this.paymentStrategies = paymentStrategies;
    }

    public String processPayment(String paymentMethod, double amount) {
        System.out.print("***paymentMethod" + paymentMethod);
        PaymentStrategy strategy = paymentStrategies.get(paymentMethod);
        if (strategy == null) {
            throw new IllegalArgumentException("Unsupported payment method: " + paymentMethod);
        }
        return strategy.processPayment(amount);
    }
}
