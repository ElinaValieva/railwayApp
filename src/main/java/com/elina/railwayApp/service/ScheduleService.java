package com.elina.railwayApp.service;

import com.elina.railwayApp.model.Schedule;
import com.elina.railwayApp.model.Station;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public interface ScheduleService {

    void add(Schedule schedule);

    void delete(Schedule schedule);

    void update(Schedule schedule);

    List<Schedule> getAll();

    Schedule getById(Long id);

    List<Schedule> getByDate(Date dateArrival);

    List<Schedule> getByStationsAndDate(Schedule schedule);

    List<Schedule> getByDateAndTrainToCheckIntersection(Schedule schedule);

    List<Schedule> getByTrainAndDate(Schedule schedule);

    List<Schedule> getByStationArrivalAndDate(Schedule schedule);

    Map<Station, List<Schedule>> getTransferList(Date date);
}

