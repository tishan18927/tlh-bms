package com.tlh.bms.service.impl;

import com.tlh.bms.data.PaymentRepository;
import com.tlh.bms.data.entities.PaymentDetailsEntity;
import com.tlh.bms.data.entities.RoomCategoryPrice;
import com.tlh.bms.representation.Payment;
import com.tlh.bms.representation.Reservation;
import com.tlh.bms.service.PaymentService;
import com.tlh.bms.service.RoomPricingService;
import com.tlh.bms.service.StripeService;
import com.tlh.bms.util.EntityToRepConverter;
import com.tlh.bms.util.RepresentationToEntityConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private RoomPricingService roomPricingService;

    @Autowired
    private StripeService stripeService;

    @Override
    @Transactional
    public Payment getReservationPayment(Payment<Reservation> payment) {
        Reservation reservationReq = payment.getReferences();
        RoomCategoryPrice price = roomPricingService.getByHotelAndRoomCategory(reservationReq.getHotel(), reservationReq.getCategory());
        payment.setAmount(price.getPrice());
        return getPayment(payment);
    }

    @Override
    @Transactional
    public Payment getPayment(Payment representation) {
        //Save transaction in db first to prevent intermediate service errors.
        //@Transactional will rollback changes if any error is thrown from stripe
        PaymentDetailsEntity saved = paymentRepository.save(
                RepresentationToEntityConverter.mergeToPaymentEntity(representation));
        stripeService.charge(representation);
        return EntityToRepConverter.convertToPaymentRep(saved);
    }
}
