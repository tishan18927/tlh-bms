package com.tlh.bms.data;

import com.tlh.bms.data.entities.RoomCategoryPrice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface RoomPriceRepository extends JpaRepository<RoomCategoryPrice, Long> {

    Set<RoomCategoryPrice> findByHotel(Long hotel);

    RoomCategoryPrice findByHotelAndRoomCategory(Long hotel, Long category);
}
