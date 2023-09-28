package com.hotel.hotelmanageservice.entities;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelEmployeeRepository extends JpaRepository<HotelEmployee, String> {
}