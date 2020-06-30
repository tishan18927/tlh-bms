package com.tlh.bms.controller;

import com.tlh.bms.representation.Payment;
import com.tlh.bms.representation.Reservation;
import com.tlh.bms.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/billing")
public class BillingController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping(path = "/charge/reservation")
    public Payment charge(@Valid @RequestBody Payment<Reservation> representation) {
        return paymentService.getReservationPayment(representation);
    }
}
