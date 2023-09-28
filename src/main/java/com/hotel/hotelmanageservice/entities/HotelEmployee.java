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
@Table(name = "hotel_employee")
public class HotelEmployee {
    @Id
    @Column(name = "emp_id", nullable = false, length = 50)
    private String empId;

    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "last_name", length = 50)
    private String lastName;

    @Column(name = "phone_no", precision = 10)
    private BigDecimal phoneNo;

    @Column(name = "email_id", length = 50)
    private String emailId;

    @Column(name = "position", length = 50)
    private String position;

}