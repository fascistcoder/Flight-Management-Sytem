package com.fms.flight_management_system.rest.controllers.impl;

import com.fms.flight_management_system.model.Airport;
import com.fms.flight_management_system.rest.controllers.AirportController;
import com.fms.flight_management_system.service.AirportService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 24/05/22
 */
@RestController
@AllArgsConstructor
public class AirportControllerImpl implements AirportController {

	private final AirportService airportService;

	@Override public ResponseEntity<List<Airport>> showAllAirports() {
		return ResponseEntity.ok(airportService.getAllAirports());
	}

	@Override public ResponseEntity<Airport> saveAirport(Airport airport) {

		Optional<Airport> airportOptional = airportService.saveAirport(airport);

		return airportOptional.map(airport1 -> ResponseEntity.ok().body(airport1)).orElseGet(() -> ResponseEntity.badRequest().body(null));
	}

	@Override public ResponseEntity<Airport> showAirportByAirportCode(String airportCode) {

		Optional<Airport> airportOptional = airportService.getAirportByAirportCode(airportCode);

		return airportOptional.map(airport -> ResponseEntity.ok().body(airport)).orElseGet(() -> ResponseEntity.badRequest().body(null));
	}

	@Override public ResponseEntity.BodyBuilder deleteAirportByAirportCode(String airportCode) {

		airportService.deleteAirport(airportCode);

		return ResponseEntity.ok();
	}
}
