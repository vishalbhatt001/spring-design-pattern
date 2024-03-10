package com.spring.design.pattern.strategy;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class PaymentConfig {
    @Bean(name = "paypal")
    public PaymentStrategy paypalPaymentStrategy() {
        return new PaypalPaymentStrategy();
    }

    @Bean(name = "stripe")
    public PaymentStrategy stripePaymentStrategy() {
        return new StripePaymentStrategy();
    }

    @Bean
    public Map<String, PaymentStrategy> paymentStrategies(@Qualifier("paypal") PaymentStrategy paypalPaymentStrategy, @Qualifier("stripe")PaymentStrategy stripePaymentStrategy) {
        Map<String, PaymentStrategy> map = new HashMap<>();
        map.put("paypal", paypalPaymentStrategy);
        map.put("stripe", stripePaymentStrategy);
        return map;
    }
}
