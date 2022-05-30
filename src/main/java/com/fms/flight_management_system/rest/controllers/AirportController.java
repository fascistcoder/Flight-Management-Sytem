package com.fms.flight_management_system.rest.controllers;

import com.fms.flight_management_system.model.Airport;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 24/05/22
 */
public interface AirportController {

	@GetMapping("/v1/show-airports-list") ResponseEntity<List<Airport>> showAllAirports();


}
