package com.bahn.dao;

import com.bahn.entity.Station;
import com.bahn.entity.Train;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TrainDAO {

    List<Train> getAllTrains();

    Train getTrainById(int id);

    Train getTrainByName(String trainName);

    void save(Train train);

    List<Integer> getStationNoByTrainNo (int trainNo);

    List<Station> getStationEntitiesNoByTrainNo (int trainNo);

    // returns names of stations
    List<String> getStationNamesByTrainNo (int trainNo);

    List<Station> getTrainsBetweenStations(int firstStationNo, int secondStationNo);

    List<Station> getStationNamesByTrainNo_CRITERIA(int trainNo);

//    List<Train> getTrainsByStationId(int stationId);
//
//    List<Train> getTrainsByStationName(String stationName);
//
//    List<Train> getTrainsFromToStationsById(int stationIdOne, int stationIdTwo);
//
    // query to return direct and transitional trains - use JOIN
    List<Train> getTrainsFromToStationsByName(String stationNameOne, String stationNameTwo);

}
