package com.fms.flight_management_system.rest.controllers;

import com.fms.flight_management_system.model.Airport;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 24/05/22
 */
public interface AirportController {

	@GetMapping("/v1/show-airports-list") ResponseEntity<List<Airport>> showAllAirports();

	@PostMapping("v1/save/Airports") ResponseEntity<Airport> saveAirport(@RequestBody @Valid Airport airport);

	@GetMapping("v1/show/airports/airport-code")
	ResponseEntity<Airport> showAirportByAirportCode(@RequestParam("airportCode") String airportCode);

	@GetMapping("v1/delete/airport")
	ResponseEntity.BodyBuilder deleteAirportByAirportCode(@RequestParam("airportCode") String airportCode);

}
