package com.bahn.controller;

import com.bahn.entity.Station;
import com.bahn.entity.Train;
import com.bahn.service.TrainStationService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.QueryParam;
import java.util.List;

@RestController
public class TrainScheduleController {

    @Autowired
    TrainStationService trainStationService;

    @RequestMapping("hello")
    public ResponseEntity<String> helloPage(){

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("MyResponseHeader", "MyValue");

        return new ResponseEntity<String>("Welcome to Deutsch Bahn!", responseHeaders, HttpStatus.OK);
    }

    /**
     * showTrainStations
     * @return list of stations, which chosen train passes by
     */
    @RequestMapping(value = "/train/{id}")
    public ResponseEntity<String> showTrainStations(@PathVariable("id") int trainNo ){

        List<Integer> st = trainStationService.displayStationsForTrain(trainNo);

        JSONObject res = new JSONObject();
        res.put("trainStations", st);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("MyResponseHeader", "MyValue");

        return new ResponseEntity<String>(res.toString(), responseHeaders, HttpStatus.OK);
    }
//
//    @RequestMapping(value = "/stations-for-train/{id}")

    @RequestMapping(value = "/trainsss/{id}")
    public Station showTrainsStations(@PathVariable("id") int trainNo ){
        List<Station> st = trainStationService.displayStationsssssForTrain(trainNo);
        return st.get(0);
    }

    @RequestMapping(value = "/route")
    public List<Train> showTrainsFromToStation(@QueryParam("from") String fromStation, @QueryParam("to") String toStation){
        List<Train> trains = trainStationService.findTrainFromToStationByName(fromStation, toStation);
        return trains;
    }

//    @RequestMapping(value = "/station/{id}")
//    public ResponseEntity<String> showStationsNameForSpecificTrain(@PathVariable("id") int trainNo ){
//
//        List<String> st = trainStationService.displayStationNamesForTrain(trainNo);
//
//        JSONObject res = new JSONObject();
//        res.put("stations_by_name", st);
//        HttpHeaders responseHeaders = new HttpHeaders();
//        responseHeaders.set("MyResponseHeader", "MyValue");
//
//        return new ResponseEntity<String>(res.toString(), responseHeaders, HttpStatus.OK);
//    }
}
