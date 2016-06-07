package com.bahn.entity;

import javax.persistence.*;

@Entity
@Table(name = "stations")
public class Station {

    @Id
    @GeneratedValue
    @Column(unique = true, nullable = false)
    Integer id;

    @Column(nullable = false)
    String name;

    @Column(name = "station_no", nullable = false)
    Integer stationNo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStationNo() {
        return stationNo;
    }

    public void setStationNo(Integer stationNo) {
        this.stationNo = stationNo;
    }
}
