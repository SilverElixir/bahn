package com.bahn.repository;


import com.bahn.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TrainRepository extends JpaRepository<Train, Integer> {

    @Query("select t from trains t where t.id = :id")
    Train getTrainById(int id);

    Train getTrainByName(String trainName);

    @Query("select * from Trains t")
    List<Train> getAllTrains();

    List<Train> getTrainsByStationId(int stationId);

    List<Train> getTrainsByStationName(String stationName);

    List<Train> getTrainsFromToStationsById(int stationIdOne, int stationIdTwo);

    // query to return direct and transitional trains - use JOIN
    List<Train> getTrainsFromToStationsByName(String stationNameOne, String stationNameTwo);
}
