package com.hotel.hotelmanageservice.services;

import com.hotel.hotelmanageservice.entities.Room;
import com.hotel.hotelmanageservice.entities.RoomRepository;
import com.hotel.hotelmanageservice.entities.RoomType;
import com.hotel.hotelmanageservice.entities.RoomTypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class FullRoomDtlService {
    Logger logger = LoggerFactory.getLogger(FullRoomDtlService.class);

    @Autowired
    RoomTypeRepository roomTypeRepository;

    @Autowired
    RoomRepository roomRepository;

    public String bookRoom(String roomTypeName, String capacity) {
        String roomRent =roomTypeRepository.findByName(roomTypeName).get().getPricePerNight();

        logger.info("The room rent is : " + roomRent);

        Room roomDtls = roomRepository.findAll().stream().filter(room -> room.getRoomStatus().equals("AVAIL")).findFirst().get();

        roomRepository.updateRoomStatusByRoomId("BOOKED",roomDtls.getRoomId());

        return roomDtls.getRoomId()+ "||"+roomRent;
    }

    public String roomCheckIn(String userName, String roomId) {

        roomRepository.updateIsOccupiedAndRoomStatusByRoomId(true,"CHECKIN",roomId);

        return "Customer Checked Into Room : "+roomId;
    }

    public String cancelRoom(String roomId) {
        roomRepository.updateIsOccupiedAndRoomStatusByRoomId(false,"AVAIL",roomId);

        return "Room Cancelled : "+roomId;
    }

    public String roomCheckOut(String userName, String reservationId,String roomId) {
        roomRepository.updateIsOccupiedAndRoomStatusByRoomId(false,"MAINT",roomId);

        return "CheckOut Done";
    }
}
