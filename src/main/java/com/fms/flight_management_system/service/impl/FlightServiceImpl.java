package com.fms.flight_management_system.service.impl;

import com.fms.flight_management_system.model.Airport;
import com.fms.flight_management_system.model.Flight;
import com.fms.flight_management_system.repository.FlightRepository;
import com.fms.flight_management_system.service.FlightService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 03/06/22
 */
@AllArgsConstructor
@Slf4j
@Service
public class FlightServiceImpl implements FlightService {

	private final FlightRepository flightRepository;

	@Override public List<Flight> getAllFlights() {
		return flightRepository.findAll();
	}

	@Override public Optional<Flight> getFlightByFlightNumber(String flightNumber) {
		return Optional.empty();
	}

	@Override public void saveFlight(Flight flight) {

	}

	@Override public void deleteFlight(String flight) {

	}

	@Override public List<Flight> getAllFlightsByAirportAndDepartureTime(Airport depAirport, Airport destAirport, LocalDate depDate) {
		return null;
	}
}
