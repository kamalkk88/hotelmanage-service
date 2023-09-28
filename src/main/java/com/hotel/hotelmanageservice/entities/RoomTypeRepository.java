package com.hotel.hotelmanageservice.entities;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomTypeRepository extends JpaRepository<RoomType, String> {
    Optional<RoomType> findByName(String name);
}