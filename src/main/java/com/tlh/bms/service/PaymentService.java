package com.tlh.bms.service;

import com.tlh.bms.representation.Payment;
import com.tlh.bms.representation.Reservation;

public interface PaymentService {

    /**
     * Make the payment
     * @param representation payment details
     * @return payment details
     */
    Payment getPayment(Payment representation);

    /**
     * Make payment for reservation
     * @param payment payment details for reservation
     * @return payment details for reservation
     */
    Payment getReservationPayment(Payment<Reservation> payment);
}
