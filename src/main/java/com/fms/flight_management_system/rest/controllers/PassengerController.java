package com.fms.flight_management_system.rest.controllers;

import com.fms.flight_management_system.rest.dtos.PassengerRequestDto;
import com.fms.flight_management_system.rest.dtos.PassengerResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 23/05/22
 */

public interface PassengerController {
	@PostMapping("/v1/passenger-request")
	ResponseEntity<PassengerResponseDto> passengerRequest(@RequestBody @Valid PassengerRequestDto passengerRequestDto);
}
