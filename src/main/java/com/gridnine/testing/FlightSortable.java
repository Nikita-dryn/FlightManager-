package com.gridnine.testing;


import java.time.LocalDateTime;
import java.util.List;

public interface FlightSortable {

    List<Flight> departureBeforeRequestedDateExclude(List<Flight> flights, LocalDateTime requestedDate);

    List<Flight> arrivalBeforeDepartureExclude(List<Flight> flights);

    List<Flight> TimeMoreThanTwoHoursExclude(List<Flight> flights);
}