package com.bahn.service;

import com.bahn.entity.Station;
import com.bahn.entity.Train;
import java.util.List;
import java.util.Optional;


public interface TrainStationService {

    /* Live Train Status
    Get Live running status of Train
    http://api.railwayapi.com/live/train/<train number>/doj/<yyyymmdd>/apikey/<apikey> */
    List<Train> getLiveStatusOfTrain(int trainNo);

    /* Train Route
    Get details about the Stations in a Train’s route.
    http://api.railwayapi.com/route/train/<train number>/apikey/<apikey> */
    List<Train> findTrainFromToStationByName(String fromStation, String toStation);

    /* Trains Between Stations
    Get Train Seat Availability
    http://api.railwayapi.com/check_seat/train/<train number>/source/<source code>/dest/<dest code>/date/<doj in DD-MM-YYYY>/class/<class code>/quota/<quota code>/apikey/<apikey> */

    /* Get Seat Availability status of a Train
    http://api.railwayapi.com/between/source/<station code>/dest/<station code>/date/dd-mm/apikey/<apikey>/ */
    List<Train> findTrainFromToSpecificStationByStationNo(int fromStationNo, int toStationNo);

    /* Train Name/Number
    Get Train name using number and vice versa.
    http://api.railwayapi.com/name_number/train/<name or number>/apikey/<apikey>/ */

    /* Get Fares of Train
    http://api.railwayapi.com/fare/train/<train number>/source/<source station code>/dest/<dest station code>/age/<age>/quota/<quota>/doj/<doj>/apikey/<apikey>/*/

    /* Train Arrivals at Station
    Get list of Trains arriving on a station within given hours with their scheduled time and live status included.
    http://api.railwayapi.com/arrivals/station/<station code>/hours/<hours to search within>/apikey/<apikey>/ */

    /* Station Name to Code
    Get station details of given station and nearby stations using station name with automatic name completion
    http://api.railwayapi.com/name_to_code/station/<station name>/apikey/<apikey>/  */

    /* Station Code to Name
    Get Station details of the passed Station and other nearby Stations using Station code
    http://api.railwayapi.com/code_to_name/code/<station code>/apikey/<apikey>/ */

    /* Station Autocomplete Suggest
    Suggest full Station names using partial Station name
    http://api.railwayapi.com/suggest_station/name/<partial station name>/apikey/<apikey>/  */

    List<Train> displayTrainsPassingTheStation(String station);

    List<Integer> displayStationsForTrain(int trainNo);

    // temporary
    List<Station> displayStationsssssForTrain(int trainNo);

    List<String> displayStationNamesForTrain(int trainNo);

}
