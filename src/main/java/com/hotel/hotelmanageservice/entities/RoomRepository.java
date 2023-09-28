package com.hotel.hotelmanageservice.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface RoomRepository extends JpaRepository<Room, String> {
    @Transactional
    @Modifying
    @Query("update Room r set r.isOccupied = ?1, r.roomStatus = ?2 where r.roomId = ?3")
    int updateIsOccupiedAndRoomStatusByRoomId(Boolean isOccupied, String roomStatus, String roomId);

    @Transactional
    @Modifying
    @Query("update Room r set r.roomStatus = ?1 where r.roomId = ?2")
    int updateRoomStatusByRoomId(String roomStatus, String roomId);
    @Transactional
    @Modifying
    @Query("update Room r set r.isOccupied = ?1 where r.roomId = ?2")
    int updateIsOccupiedByRoomId(Boolean isOccupied, String roomId);
}