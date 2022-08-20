package com.fms.flight_management_system.repository;

import com.fms.flight_management_system.model.Airport;
import com.fms.flight_management_system.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 03/06/22
 */
public interface FlightRepository extends JpaRepository<Flight, UUID> {
	Optional<Flight> findByFlightNumber(String flightNo);

	void deleteFlightByFlightNumber(String flightNo);

	List<Flight> getAllByDepartureAirportAndDestinationAirportAndDepartureDate(Airport depAirport, Airport destAirport, LocalDate depDate);

}
