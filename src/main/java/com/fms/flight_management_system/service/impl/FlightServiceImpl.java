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

	@Override public List<Flight> getAllFlight() {

		log.info("Displaying all the Flights");

		return flightRepository.findAll();
	}

	@Override public Optional<Flight> getFlightByFlightNumber(String flightNo) {

		log.info("Find the aircraft by flight No {} ", flightNo);

		return flightRepository.findByFlightNumber(flightNo);
	}

	@Override public void saveFlight(Flight flight) {
		Optional<Flight> flightOptional = getFlightByFlightNumber(flight.getFlightNumber());

		flightOptional.map(flight1 -> {
			log.info("Flight already present model {} ", flight1.getFlightNumber());
			return null;
		}).orElseGet(() -> {
			log.info("Flight had been saved {} ", flight.getFlightNumber());
			flightRepository.save(flight);
			return null;
		});
	}

	@Override public void deleteFlight(String flightNo) {
		Optional<Flight> flightOptional = getFlightByFlightNumber(flightNo);
		flightOptional.map(flight1 -> {
			log.info("Flight found by flight no {} ", flightNo);
			flightRepository.deleteFlightByFlightNumber(flightNo);
			return null;
		}).orElseGet(() -> {
			log.info("Flight Not found {} ", flightNo);
			return null;
		});
	}

	@Override public List<Flight> getAllFlightByAirportAndDepartureTime(Airport depAirport, Airport destAirport, LocalDate depDate) {
		List<Flight> flights = flightRepository.getAllByDepartureAirportAndDestinationAirportAndDepartureDate(depAirport, destAirport, depDate);
		if (flights.isEmpty()) {
			return null;
		}
		return flights;
	}
}
