package com.tlh.bms.controller;

import com.tlh.bms.data.entities.RoomCategoryPrice;
import com.tlh.bms.service.RoomPricingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(path = "/pricing")
public class PriceController {

    @Autowired
    private RoomPricingService roomPricingService;

    @GetMapping(path = "/rooms/{hotel}")
    public Map<Long, RoomCategoryPrice> getPricingsForRooms(@PathVariable("hotel") Long hotel) {
        return roomPricingService.getPrices(hotel);
    }
}
