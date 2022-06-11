package com.fms.flight_management_system.service;

import com.fms.flight_management_system.model.Airport;
import com.fms.flight_management_system.model.Flight;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 03/06/22
 */
public interface FlightService {
	List<Flight> getAllFlights();

	Optional<Flight> getFlightByFlightNumber(String flightNumber);

	void saveFlight(Flight flight);

	void deleteFlight(String flight);

	List<Flight> getAllFlightsByAirportAndDepartureTime(Airport depAirport, Airport destAirport, LocalDate depDate);
}
