package com.tlh.bms.util;

import com.tlh.bms.data.entities.PaymentDetailsEntity;
import com.tlh.bms.representation.Payment;

public class EntityToRepConverter {

    public static Payment convertToPaymentRep(PaymentDetailsEntity entity) {
        Payment representation = new Payment();
        representation.setId(entity.getId());
        representation.setAmount(entity.getAmount());
        representation.setRowVersion(entity.getRowVersion());
        representation.setRefId(entity.getRefId());
        representation.setPaymentType(entity.getPaymentType());
        representation.setCreatedBy(entity.getCreatedBy());
        representation.setCreatedAt(entity.getCreatedAt());
        return representation;
    }

}
