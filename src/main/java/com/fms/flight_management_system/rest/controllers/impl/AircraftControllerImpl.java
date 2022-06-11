package com.fms.flight_management_system.rest.controllers.impl;

import com.fms.flight_management_system.model.Aircraft;
import com.fms.flight_management_system.rest.controllers.AircraftController;
import com.fms.flight_management_system.service.AircraftService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 03/06/22
 */
@AllArgsConstructor
@RestController
public class AircraftControllerImpl implements AircraftController {
	private final AircraftService aircraftService;

	@Override public ResponseEntity<List<Aircraft>> showAllAircraft() {
		return ResponseEntity.ok().body(aircraftService.getAllAircraft());
	}

	@Override public ResponseEntity<Aircraft> saveAircraft(Aircraft aircraft) {

		aircraftService.saveAircraft(aircraft);

		return ResponseEntity.ok().body(aircraft);
	}

	@Override public ResponseEntity<Aircraft> showAircraftByAircraftModel(String aircraftModel) {

		Optional<Aircraft> aircraftOptional = aircraftService.getAircraftByAircraftModel(aircraftModel);

		return aircraftOptional.map(aircraft -> ResponseEntity.ok().body(aircraft)).orElseGet(() -> ResponseEntity.badRequest().body(null));
	}

	@Override public ResponseEntity.BodyBuilder deleteAircraftByAircraftModel(String aircraftModel) {

		aircraftService.deleteAircraft(aircraftModel);

		return ResponseEntity.ok();
	}
}
