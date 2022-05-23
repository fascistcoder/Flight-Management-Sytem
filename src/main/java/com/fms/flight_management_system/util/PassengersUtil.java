package com.fms.flight_management_system.util;

import com.fms.flight_management_system.model.Passengers;
import com.fms.flight_management_system.rest.dtos.PassengerResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 23/05/22
 */
@Component
@Slf4j
public class PassengersUtil {

	public PassengerResponseDto buildPassengerResponseDto(Passengers passengers){
		PassengerResponseDto passengerResponseDto = PassengerResponseDto.builder()
				.email(passengers.getEmail())
				.firstName(passengers.getFirstName())
				.lastName(passengers.getLastName())
				.phoneNumber(passengers.getPhoneNumber())
				.passengerUniqueId(passengers.getId())
				.build();

		log.info("Passenger Response {} ", passengerResponseDto);
		return passengerResponseDto;
	}
}
