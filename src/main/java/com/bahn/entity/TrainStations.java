package com.bahn.entity;

import javax.persistence.*;

@Entity
@Table(name = "train_stations")
public class TrainStations {

    @Id
    @GeneratedValue
    @Column(unique = true, nullable = false)
    Integer id;

    @Column(name = "train_no", nullable = false)
    Integer trainNo;

    @Column(name = "station_no", nullable = false)
    Integer stationNo;

    @Column(name = "seq_station_no", nullable = false)
    Integer sequentialStationNo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(Integer trainNo) {
        this.trainNo = trainNo;
    }

    public Integer getStationNo() {
        return stationNo;
    }

    public void setStationNo(Integer stationNo) {
        this.stationNo = stationNo;
    }

    public Integer getSequentialStationNo() {
        return sequentialStationNo;
    }

    public void setSequentialStationNo(Integer sequentialStationNo) {
        this.sequentialStationNo = sequentialStationNo;
    }
}

