package com.fms.flight_management_system.service;

import com.fms.flight_management_system.model.Airport;

import java.util.List;
import java.util.Optional;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 24/05/22
 */
public interface AirportService {

	List<Airport> getAllAirports();

	Optional<Airport> getAirportByAirportCode(String airportCode);

	Optional<Airport> saveAirport(Airport airport);

	void deleteAirport(String airportCode);

}
