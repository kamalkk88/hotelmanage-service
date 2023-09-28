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
@Table(name = "room_features")
public class RoomFeature {
    @Id
    @Column(name = "feature_id", nullable = false, length = 50)
    private String featureId;

    @Column(name = "room_id", length = 50)
    private String roomId;

    @Column(name = "feature_name", length = 50)
    private String featureName;

}