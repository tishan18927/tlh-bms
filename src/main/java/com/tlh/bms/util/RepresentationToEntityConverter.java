package com.tlh.bms.util;

import com.tlh.bms.data.entities.PaymentDetailsEntity;
import com.tlh.bms.representation.Payment;

public class RepresentationToEntityConverter {

    public static PaymentDetailsEntity mergeToPaymentEntity(Payment representation) {
        PaymentDetailsEntity entity = new PaymentDetailsEntity();
        entity.setId(representation.getId());
        entity.setRowVersion(representation.getRowVersion());
        entity.setAmount(representation.getAmount());
        entity.setPaymentType(representation.getPaymentType());
        entity.setPaymentToken(representation.getPaymentToken());
        entity.setRefId(representation.getRefId());
        entity.setCreatedBy("test-user");
        entity.setCreatedAt(System.currentTimeMillis());
        return entity;
    }
}
