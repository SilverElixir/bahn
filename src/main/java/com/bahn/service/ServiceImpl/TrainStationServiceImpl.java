package com.bahn.service.ServiceImpl;


import com.bahn.dao.TrainDAO;
import com.bahn.dao.impl.TrainDAOImpl;
import com.bahn.entity.Station;
import com.bahn.entity.Train;
import com.bahn.repository.TrainRepository;
import com.bahn.service.TrainStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class TrainStationServiceImpl implements TrainStationService {

    @Autowired
    TrainDAO trainDAO;

//    @Autowired
//    TrainRepository trainRepository;

    @Override
    public List<Train> getLiveStatusOfTrain(int trainNo) {
        return null;
    }

    @Override
    public List<Train> findTrainFromToStationByName(String fromStation, String toStation) {
        if(!trainDAO.getAllTrains().isEmpty()){
            // getTrainsFromToStationsByName(fromStation, toStation).isEmpty()){
            // replace sysout with Logger
            System.out.println("Unfortunately, there's no train, going between station, you're looking for");
            return null;
        }else {
            return null;
        }
    }

    @Override
    public List<Train> findTrainFromToSpecificStationByStationNo(int fromStationNo, int toStationNo) {
        return null;
    }

    @Override
    public List<Train> displayTrainsPassingTheStation(String station) {
        return null;
    }

    @Override
    public List<Integer> displayStationsForTrain(int trainNo) {
        return trainDAO.getStationNoByTrainNo(trainNo);
    }

    @Override
    public List<Station> displayStationsssssForTrain(int trainNo) {
        return trainDAO.getStationEntitiesNoByTrainNo(trainNo);
    }

    @Override
    public List<String> displayStationNamesForTrain(int trainNo) {
        return trainDAO.getStationNamesByTrainNo(trainNo);
    }

}
