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
@Table(name = "hoteldetails")
public class HotelDetail {
    @Id
    @Column(name = "hotel_id", nullable = false, length = 50)
    private String hotelId;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "description", nullable = false, length = 50)
    private String description;

    @Column(name = "address", nullable = false, length = 50)
    private String address;

    @Column(name = "type", nullable = false, length = 50)
    private String type;

    @Column(name = "phone", length = 50)
    private String phone;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "city", length = 50)
    private String city;

    @Column(name = "website_name", length = 50)
    private String websiteName;

    @Column(name = "country", length = 50)
    private String country;

}