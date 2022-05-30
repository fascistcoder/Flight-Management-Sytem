package com.fms.flight_management_system.rest.controllers.impl;

import com.fms.flight_management_system.model.Airport;
import com.fms.flight_management_system.rest.controllers.AirportController;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 24/05/22
 */
@RestController
@AllArgsConstructor
public class AirportControllerImpl implements AirportController {
	@Override public ResponseEntity<List<Airport>> showAllAirports() {
		return null;
	}
}
