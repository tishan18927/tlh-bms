package com.tlh.bms.representation;

import com.tlh.bms.common.constants.PaymentType;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class Payment<T> {

    @Valid
    private T references;

    private Long id;

    private Integer rowVersion;

    @NotBlank(message = "Please add PaymentToken!")
    private String paymentToken;

    @NotNull(message = "Please add PaymentType!")
    private PaymentType paymentType;

    private Long amount;

    @NotNull(message = "Please add Reference!")
    private Long refId;

    private String createdBy;

    private Long createdAt;

}
