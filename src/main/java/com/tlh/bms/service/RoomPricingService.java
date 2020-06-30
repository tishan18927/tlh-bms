package com.tlh.bms.service;

import com.tlh.bms.data.entities.RoomCategoryPrice;

import java.util.Map;

public interface RoomPricingService {

    /**
     *
     * @param hotel selected hotel id
     * @return price against category
     */
    Map<Long, RoomCategoryPrice> getPrices(Long hotel);

    /**
     *
     * @param hotel selected hotel
     * @param roomCategory
     * @return price for selected room category
     */
    RoomCategoryPrice getByHotelAndRoomCategory(Long hotel, Long roomCategory);
}
