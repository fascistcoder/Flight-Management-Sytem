package com.fms.flight_management_system.rest.controllers.impl;

import com.fms.flight_management_system.rest.controllers.PassengerController;
import com.fms.flight_management_system.rest.dtos.PassengerRequestDto;
import com.fms.flight_management_system.rest.dtos.PassengerResponseDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 23/05/22
 */
@AllArgsConstructor
@Slf4j
@RestController
public class PassengerControllerImpl implements PassengerController {

	@Override public ResponseEntity<PassengerResponseDto> passengerRequest(PassengerRequestDto passengerRequestDto) {
		return null;
	}
}
