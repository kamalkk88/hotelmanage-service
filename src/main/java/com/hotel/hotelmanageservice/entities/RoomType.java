package com.hotel.hotelmanageservice.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "room_types")
public class RoomType {
    @Id
    @Column(name = "room_type_id", nullable = false, length = 50)
    private String roomTypeId;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "description", length = 50)
    private String description;

    @Column(name = "capacity", length = 10)
    private String capacity;

    @Column(name = "price_per_night", length = 10)
    private String pricePerNight;

}