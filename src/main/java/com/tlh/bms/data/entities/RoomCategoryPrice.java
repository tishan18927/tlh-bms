package com.tlh.bms.data.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ROOM_CATEGORY_PRICE", uniqueConstraints = {@UniqueConstraint(name = "HOSPITAL_PRICE_UC", columnNames = {"HOTEL", "ROOM_CATEGORY"})})
public class RoomCategoryPrice extends BaseEntity{

    @Column(name = "HOTEL", nullable = false)
    private Long hotel;

    @Column(name = "ROOM_CATEGORY", nullable = false)
    private Long roomCategory;

    @Column(name = "PRICE", nullable = false)
    private Long price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoomCategoryPrice)) return false;
        RoomCategoryPrice that = (RoomCategoryPrice) o;
        return hotel.equals(that.hotel) &&
                roomCategory.equals(that.roomCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hotel, roomCategory);
    }
}
