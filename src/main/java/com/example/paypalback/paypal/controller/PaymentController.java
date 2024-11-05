package com.example.paypalback.paypal.controller;

import com.example.paypalback.paypal.model.CompletedOrder;
import com.example.paypalback.paypal.model.PaymentOrder;
import com.example.paypalback.paypal.service.PaypalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping(value = "/paypal")
//@CrossOrigin(origins = "http://localhost:4200")
public class PaymentController {
    @Autowired
    private PaypalService paypalService;

    @PostMapping(value = "/init")
    public PaymentOrder createPayment(
            @RequestParam("sum") BigDecimal sum) {
        return paypalService.createPayment(sum);
    }

    @PostMapping(value = "/capture")
    public CompletedOrder completePayment(@RequestParam("token") String token) {
        return paypalService.completePayment(token);
    }
}
