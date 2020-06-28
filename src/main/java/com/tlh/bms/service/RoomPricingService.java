package com.tlh.bms.service;

import com.tlh.bms.data.entities.RoomCategoryPrice;

import java.util.Map;

public interface RoomPricingService {

    Map<Long, RoomCategoryPrice> getPrices(Long hotel);
}
