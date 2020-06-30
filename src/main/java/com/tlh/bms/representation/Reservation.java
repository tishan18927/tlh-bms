package com.tlh.bms.representation;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class Reservation {
    @NotNull(message = "Please add Hotel!")
    private Long hotel;

    @NotNull(message = "Please add Room Category!")
    private Long category;
}
