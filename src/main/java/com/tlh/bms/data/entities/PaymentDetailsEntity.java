package com.tlh.bms.data.entities;

import com.tlh.bms.common.constants.PaymentType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Version;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "PAYMENT_ENTITY")
public class PaymentDetailsEntity extends BaseEntity {

    @Column(name = "PAYMENT_TOKEN", nullable = false)
    private String paymentToken;

    @Enumerated(EnumType.STRING)
    @Column(name = "PAYMENT_TYPE", nullable = false)
    private PaymentType paymentType;

    @Column(name = "AMOUNT", nullable = false)
    private Long amount;

    @Column(name = "REFERENCE_ID", nullable = false)
    private Long refId;

    @Version
    @Column(name = "ROW_VERSION", nullable = false)
    private Integer rowVersion;

    @Column(name = "CREATED_BY", nullable = false, length = 36)
    private String createdBy;

    @Column(name = "CREATED_AT", nullable = false)
    private Long createdAt;

}
