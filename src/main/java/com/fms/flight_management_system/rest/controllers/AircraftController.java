package com.fms.flight_management_system.rest.controllers;

import com.fms.flight_management_system.model.Aircraft;
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
 * @since 03/06/22
 */
public interface AircraftController {
	@GetMapping("/v1/show-aircraft-list") ResponseEntity<List<Aircraft>> showAllAircraft();

	@PostMapping("v1/save/aircraft") ResponseEntity<Aircraft> saveAircraft(@RequestBody @Valid Aircraft aircraft);

	@GetMapping("v1/show/aircraft/aircraft-model")
	ResponseEntity<Aircraft> showAircraftByAircraftModel(@RequestParam("aircraftModel") String aircraftModel);

	@GetMapping("v1/delete/aircraft")
	ResponseEntity.BodyBuilder deleteAircraftByAircraftModel(@RequestParam("aircraftModel") String aircraftModel);
}
