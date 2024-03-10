package com.spring.design.pattern.strategy;

public class StripePaymentStrategy implements PaymentStrategy{
    @Override
    public String processPayment(double amount) {
        return "Payment processed successfully using Stripe for amount: $" + amount;
    }
}
