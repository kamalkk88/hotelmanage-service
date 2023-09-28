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
@Table(name = "room_maintenance")
public class RoomMaintenance {
    @Id
    @Column(name = "maintenance_id", nullable = false, length = 50)
    private String maintenanceId;

    @Column(name = "room_id", length = 50)
    private String roomId;

    @Column(name = "maintenance_date", length = 50)
    private String maintenanceDate;

    @Column(name = "description", length = 50)
    private String description;

}