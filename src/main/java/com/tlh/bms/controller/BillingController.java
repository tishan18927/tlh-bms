package com.tlh.bms.controller;

import com.tlh.bms.representation.PaymentRepresentation;
import com.tlh.bms.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/billing")
public class BillingController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping(path = "/charge")
    public PaymentRepresentation charge(PaymentRepresentation representation) {
        return paymentService.getPayment(representation);
    }
}
