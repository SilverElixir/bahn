package com.bahn.dao.impl;

import com.bahn.dao.TrainDAO;
import com.bahn.entity.Station;
import com.bahn.entity.Train;
import com.bahn.entity.TrainStations;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TrainDAOImpl implements TrainDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Train> getAllTrains() {
        Session session = this.sessionFactory.openSession();
        List<Train> trains = session.createQuery("from Train").list();
        session.close();
        return trains;
    }

    @Override
    public Train getTrainById(int id) {
        Session session = this.sessionFactory.openSession();
        //Train train = session.createQuery("t from trains t where t.train_id = id").uniqueResult();
        return null;
    }

    @Override
    public Train getTrainByName(String trainName) {
        return null;
    }

//    @Override
//    public List<Train> getTrainsByStationId(int stationId) {
//        Session session = this.sessionFactory.openSession();
//        List<Train> trains = session.createQuery("from trains where t.").list();
//        return trains;
//    }
//
//    @Override
//    public List<Train> getTrainsByStationName(String stationName) {
//        return null;
//    }
//
//    @Override
//    public List<Train> getTrainsFromToStationsById(int stationIdOne, int stationIdTwo) {
//        return null;
//    }
//
//    @Override
//    public List<Train> getTrainsFromToStationsByName(String stationNameOne, String stationNameTwo) {
//        return null;
//    }

    @Override
    public void save(Train train) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(train);
        tx.commit();
        session.close();
        System.out.println("New train " + train + "was successfully saved into DB");
    }

    @Override
    public List<Integer> getStationNoByTrainNo(int trainNo) {
        Session session = this.sessionFactory.openSession();
        List<Integer> stations = session.createQuery("select ts.stationNo from TrainStations ts where ts.trainNo = :trainNo")
                .setInteger("trainNo", trainNo).list();
        session.close();
        return stations;
    }

    @Override
    public List<Station> getStationEntitiesNoByTrainNo(int trainNo) {
        Session session = this.sessionFactory.openSession();
        List<Station> stations = session.createQuery("from TrainStations ts where ts.trainNo = :trainNo")
                .setInteger("trainNo", trainNo).list();
        session.close();
        return stations;
    }

    @Override
    public List<String> getStationNamesByTrainNo(int trainNo) {
        Session session = this.sessionFactory.openSession();
//        select s.name from stations s join train_stations ts
//        ->  on s.station_no = ts.station_no
//        ->  where ts.train_no = 50
        List<String> stations = session.createSQLQuery("select s.name from Station s join TrainStations ts on" +
                " s.stationNo = ts.stationNo where ts.trainNo = :trainNo").setInteger("trainNo", trainNo).list();
        session.close();
        return stations;
    }

    @Override
    public List<Station> getTrainsBetweenStations(int firstStationNo, int secondStationNo) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Train.class);
        criteria.add(Restrictions.between("station_no", firstStationNo, secondStationNo));
//        criteria.add(Restrictions.eq("campaignId", campaignId));
//        criteria.add(Restrictions.isNotNull("name"));
//        criteria.add(Restrictions.eq("service", service));
//        criteria.add(Restrictions.eq("status", TargetingProfileStatus.ACTIVE));
//        criteria.setFetchMode("targetingValues", FetchMode.JOIN);
//        criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);

        return criteria.list();
    }

    @Override
    public List<Station> getStationNamesByTrainNo_CRITERIA(int trainNo) {
//        select s.name from stations s join train_stations ts
//        ->  on s.station_no = ts.station_no
//        ->  where ts.train_no = 50
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Station.class);
//        List<Station> stations = criteria
//                .setFetchMode("stations", FetchMode.JOIN)
//                .setFetchMode("train_stations", FetchMode.JOIN)
//                .add(Restrictions.eq("name", stationName))
//                .list();
//
//
////                session.createSQLQuery("select s.name from Station s join TrainStations ts on" +
////                " s.stationNo = ts.stationNo where ts.trainNo = :trainNo").setInteger("trainNo", trainNo).list();
//        session.close();
        return null;
    }

    @Override
    public List<Train> getTrainsFromToStationsByName(String stationNameOne, String stationNameTwo) {
        Session session = sessionFactory.getCurrentSession();
        List<Train> trains = session.createSQLQuery("select t.`train_id`,\n" +
                "        concat(t.`first_station`, '-', t.`last_station`) as train_name,\n" +
                "from trains t\n" +
                "left join (select r.`train_no`, s.`name`, r.`seq_station_no` from train_stations r\n" +
                "            inner join stations s on s.`station_no` = r.`station_no`\n" +
                "            where s.`name` = 'Lviv') tmp1 -- this is first city station\n" +
                "on tmp1.`train_no` = t.`train_id`\n" +
                "left join (select r.`train_no`, s.`name`, r.`seq_station_no` from train_stations r\n" +
                "            inner join stations s on s.`station_no` = r.`station_no`\n" +
                "            where s.`name` = 'Kyiv') tmp2 -- this is last city station\n" +
                "on tmp2.`train_no` = t.`train_id`\n" +
                "left join (select r.`train_no`, count(*) as `numb_of_stations` from train_stations r\n" +
                "            group by r.`train_no`) tmp3\n" +
                "on tmp3.`train_no` = t.`train_id`\n" +
                "where tmp2.`seq_station_no` > tmp1.`seq_station_no`;\n").list();
//        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TrainStations.class);
//        List<Train> trains = criteria
//                .setFetchMode("train_stations", FetchMode.JOIN)
//                .add(Restrictions.gt("seq_station_no", ))
        return trains;

    }


}
