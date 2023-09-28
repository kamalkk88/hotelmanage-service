package com.hotel.hotelmanageservice.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class FullRoomDetails {
    Room roomDtls;

    @Getter
    @Setter
    List<RoomType> roomType;

}
