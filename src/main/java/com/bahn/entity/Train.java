package com.bahn.entity;

import javax.persistence.*;

@Entity
@Table(name = "trains")
public class Train {

    @Id
    @Column(name = "train_id", unique = true, nullable = false)
    Integer trainNo;

    @Column(name = "first_station", nullable = false)
    String firstStation;

    @Column(name = "first_station_no", nullable = false)
    Integer firstStationNo;

    @Column(name = "last_station", nullable = false)
    String lastStation;

    @Column(name = "last_station_no", nullable = false)
    Integer lastStationNo;

    public Integer getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(Integer trainNo) {
        this.trainNo = trainNo;
    }

    public String getFirstStation() {
        return firstStation;
    }

    public void setFirstStation(String firstStation) {
        this.firstStation = firstStation;
    }

    public Integer getFirstStationNo() {
        return firstStationNo;
    }

    public void setFirstStationNo(Integer firstStationNo) {
        this.firstStationNo = firstStationNo;
    }

    public String getLastStation() {
        return lastStation;
    }

    public void setLastStation(String lastStation) {
        this.lastStation = lastStation;
    }

    public Integer getLastStationNo() {
        return lastStationNo;
    }

    public void setLastStationNo(Integer lastStationNo) {
        this.lastStationNo = lastStationNo;
    }
}
