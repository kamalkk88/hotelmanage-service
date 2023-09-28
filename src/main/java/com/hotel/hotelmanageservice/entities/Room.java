package com.hotel.hotelmanageservice.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "room")
public class Room {
    @Id
    @Column(name = "room_id", nullable = false, length = 10)
    private String roomId;

    @Column(name = "hotel_id", length = 50)
    private String hotelId;

    @Column(name = "room_type_id", nullable = false, length = 50)
    private String roomTypeId;

    @Column(name = "room_number", nullable = false, length = 10)
    private String roomNumber;

    @Column(name = "is_occupied")
    private Boolean isOccupied;

    @Column(name = "room_status", length = 20)
    private String roomStatus;
}