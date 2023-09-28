package com.hotel.hotelmanageservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class HotelManageServiceApplication {

    public static void main(String[] args) {

        new SpringApplicationBuilder()
                .profiles("dev").sources(HotelManageServiceApplication.class)
                .run(args);
    }

}
