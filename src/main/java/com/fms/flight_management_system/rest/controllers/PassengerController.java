package com.fms.flight_management_system.rest.controllers;

import com.fms.flight_management_system.model.Passengers;
import com.fms.flight_management_system.rest.dtos.PassengerRequestDto;
import com.fms.flight_management_system.rest.dtos.PassengerResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 23/05/22
 */

public interface PassengerController {
	@GetMapping("/v1/details/passengers/email")
	ResponseEntity<Passengers> showPassengersByEmail(@RequestParam("email") String email, @RequestParam("phoneNumber") Long phoneNumber);

	@PostMapping("/v1/save/passengers")
	ResponseEntity<PassengerResponseDto> savePassengers(@RequestBody @Valid PassengerRequestDto passengerRequestDto);

	@GetMapping("/v1/show-all/passengers")
	ResponseEntity<List<Passengers>> showAllPassengers();

	@GetMapping("/v1/delete/passengers/email")
	ResponseEntity.BodyBuilder deletePassengerByEmail(@RequestParam("passengerEmail")String email);

	@GetMapping("/v1/delete/passengers/id")
	ResponseEntity.BodyBuilder deletePassengerById(@RequestParam("passengerId") UUID uuid);

	@GetMapping("/v1/show/passengers/id")
	ResponseEntity<PassengerResponseDto> showPassengersById(@RequestParam("passengerId") UUID uuid);

}
