package com.tlh.bms.service;

import com.stripe.Stripe;
import com.tlh.bms.common.constants.Currency;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.tlh.bms.common.error.ErrorType;
import com.tlh.bms.common.error.ServiceException;
import com.tlh.bms.representation.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class StripeService {

    @Value("${stripe.secret_key}")
    private String secretKey;

    @PostConstruct
    public void init() {
        Stripe.apiKey = secretKey;
    }

    /**
     * Make payment using Stripe platform
     * @param payment payment details
     * @return charge details
     */
    public Charge charge(Payment payment) {
        Map<String, Object> chargeParams = new HashMap<>();
        chargeParams.put("amount", payment.getAmount());
        chargeParams.put("currency", Currency.GBP);
        chargeParams.put("description", payment.getPaymentType());
        chargeParams.put("source", payment.getPaymentToken());
        try {
            return Charge.create(chargeParams);
        } catch (StripeException e) {
            throw new ServiceException(ErrorType.STRIPE_ERROR, e.getMessage());
        }
    }
}
