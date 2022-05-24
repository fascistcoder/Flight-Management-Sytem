package com.fms.flight_management_system.service;

import com.fms.flight_management_system.model.Passengers;
import com.fms.flight_management_system.rest.dtos.PassengerRequestDto;
import com.fms.flight_management_system.rest.dtos.PassengerResponseDto;

import java.util.List;
import java.util.Optional;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 23/05/22
 */
public interface PassengerService {
	List<Passengers> getAllPassengers();

	Optional<Passengers> getPassengerByEmailAndPhoneNumber(String email, Long phoneNumber);

	PassengerResponseDto savePassenger(PassengerRequestDto passengerRequestDto);

	void deletePassengerByEmail(String email);
}
