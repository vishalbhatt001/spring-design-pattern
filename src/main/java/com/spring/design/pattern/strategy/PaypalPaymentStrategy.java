package com.spring.design.pattern.strategy;

public class PaypalPaymentStrategy implements PaymentStrategy{
    @Override
    public String processPayment(double amount) {
        return "Payment processed successfully using PayPal for amount: $" + amount;
    }
}
