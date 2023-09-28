package com.hotel.hotelmanageservice.controller;

import com.hotel.hotelmanageservice.entities.*;
import com.hotel.hotelmanageservice.services.FullRoomDtlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class HotelManagementController {

    Logger logger = LoggerFactory.getLogger(HotelManagementController.class);

    @Autowired
    HotelDetailRepository hotelDetailRepository;

    @Autowired
    HotelEmployeeRepository hotelEmployeeRepository;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    RoomFeatureRepository roomFeatureRepository;

    @Autowired
    RoomMaintenanceRepository roomMaintenanceRepository;

    @Autowired
    RoomTypeRepository roomTypeRepository;

    @Autowired
    FullRoomDtlService fullRoomDtlService;

    @PostMapping("/save/hotel/details")
    public ResponseEntity<String> createHotel(@RequestBody HotelDetail hotelDetail){
        logger.info("Inside Creation of Hotel");
        hotelDetail.setHotelId(String.valueOf((int)(Math.random()*100000)));
        hotelDetailRepository.save(hotelDetail);

        return new ResponseEntity<>("Hotel Details Saved", HttpStatus.OK);

    }

    @GetMapping("/get/hotel/{hotelId}")
    public HotelDetail getHotelDtlsOnId(@PathVariable("hotelId") String hotelId){
        return hotelDetailRepository.findById(hotelId).get();
    }

    @PostMapping("/save/room/details")
    public ResponseEntity<String> saveRoomDetails(@RequestBody Room room){
        logger.info("Inside Creation of Room in a hotel");
        room.setRoomId(String.valueOf((int)(Math.random()*100000)));
        roomRepository.save(room);

        return new ResponseEntity<>("Room Details Saved", HttpStatus.OK);

    }

    @PostMapping("/save/room/type")
    public ResponseEntity<String> saveRoomType(@RequestBody RoomType roomType){
        logger.info("Inside Creation of Room Type in a hotel");
        roomType.setRoomTypeId(String.valueOf((int)(Math.random()*100000)));
        roomTypeRepository.save(roomType);

        return new ResponseEntity<>("Room Type Details Saved", HttpStatus.OK);
    }

    @PostMapping("/save/room/features")
    public ResponseEntity<String> saveRoomFeatures(@RequestBody RoomFeature roomFeature){
        logger.info("Inside Creation of Room Features in a hotel");
        roomFeature.setFeatureId(String.valueOf((int)(Math.random()*100000)));
        roomFeatureRepository.save(roomFeature);

        return new ResponseEntity<>("Room Features Details Saved", HttpStatus.OK);
    }

    @PostMapping("/save/employee/details")
    public ResponseEntity<String> createHotelEmployee(@RequestBody HotelEmployee hotelEmployee){
        logger.info("Inside hotel Employee Registration");
        hotelEmployee.setEmpId(String.valueOf((int)(Math.random()*100000)));
        hotelEmployeeRepository.save(hotelEmployee);

        return ResponseEntity.ok("Employee Details Saved");
    }

    @GetMapping("/get/all/employees")
    public List<HotelEmployee> getAllEmployees() { return hotelEmployeeRepository.findAll(); }

    @GetMapping("/get/employee/{empId}")
    public HotelEmployee getParticularEmployee(@PathVariable("empId") String empId){
        return hotelEmployeeRepository.findById(empId).get();
    }

    @PostMapping("/book/room/{roomTypeName}/{capacity}")
    public ResponseEntity<String> bookRoom(@PathVariable("roomTypeName") String roomTypeName,
                                           @PathVariable("capacity") String capacity){

        String resp = fullRoomDtlService.bookRoom(roomTypeName,capacity);

        return new ResponseEntity<>(resp,HttpStatus.OK);
    }

    @PostMapping("/room/checkin/{username}/{roomId}")
    public ResponseEntity<String> roomCheckIn(@PathVariable("username") String userName,
                                              @PathVariable("roomId") String roomId){

        String resp = fullRoomDtlService.roomCheckIn(userName,roomId);

        return new ResponseEntity<>(resp,HttpStatus.OK);
    }

    @PostMapping("/room/cancel/{roomId}")
    public ResponseEntity<String> cancelRoom(@PathVariable("roomId") String roomId){

        String resp = fullRoomDtlService.cancelRoom(roomId);

        return new ResponseEntity<>(resp,HttpStatus.OK);
    }

    @PostMapping("/room/checkout/{username}/{reservationId}/{roomId}")
    public ResponseEntity<String> roomCheckOut(@PathVariable("username") String userName,
                                              @PathVariable("reservationId") String reservationId,
                                              @PathVariable("roomId") String roomId){

        String resp = fullRoomDtlService.roomCheckOut(userName,reservationId,roomId);

        return new ResponseEntity<>(resp,HttpStatus.OK);
    }
}
