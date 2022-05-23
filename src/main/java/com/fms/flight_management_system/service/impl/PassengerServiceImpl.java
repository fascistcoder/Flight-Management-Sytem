package com.fms.flight_management_system.service.impl;

import com.fms.flight_management_system.model.Passengers;
import com.fms.flight_management_system.repository.PassengerRepository;
import com.fms.flight_management_system.service.PassengerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 23/05/22
 */
@AllArgsConstructor
@Slf4j
@Service
public class PassengerServiceImpl implements PassengerService {

	private final PassengerRepository passengerRepository;

	@Override public List<Passengers> getAllPassengers() {
		return null;
	}

	@Override public Passengers getPassengerById(Long passengerId) {
		return null;
	}

	@Override public Passengers savePassenger(Passengers passenger) {
		return null;
	}

	@Override public void deletePassengerById(Long passengerId) {

	}

	@Override public void updatePassengerByDetails(String email, Long phoneNumber) {

	}
}
