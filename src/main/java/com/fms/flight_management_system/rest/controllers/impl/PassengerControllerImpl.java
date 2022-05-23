package com.fms.flight_management_system.rest.controllers.impl;

import com.fms.flight_management_system.model.Passengers;
import com.fms.flight_management_system.rest.controllers.PassengerController;
import com.fms.flight_management_system.rest.dtos.PassengerRequestDto;
import com.fms.flight_management_system.rest.dtos.PassengerResponseDto;
import com.fms.flight_management_system.service.PassengerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 23/05/22
 */
@AllArgsConstructor
@Slf4j
@RestController
public class PassengerControllerImpl implements PassengerController {

	private final PassengerService passengerService;

	@Override public ResponseEntity<Passengers> showPassengers(String email, Long phoneNumber) {
		Optional<Passengers> passengersOp = passengerService.getPassengerByEmailAndPhoneNumber(email, phoneNumber);

		return passengersOp.map(passengers -> ResponseEntity.ok(passengersOp.get())).orElseGet(()-> ResponseEntity.badRequest().body(null));
	}

	@Override public ResponseEntity<PassengerResponseDto> savePassengers(@Valid PassengerRequestDto passengerRequestDto) {

		PassengerResponseDto passengerResponseDto = passengerService.savePassenger(passengerRequestDto);

		return ResponseEntity.ok().body(passengerResponseDto);
	}
}
