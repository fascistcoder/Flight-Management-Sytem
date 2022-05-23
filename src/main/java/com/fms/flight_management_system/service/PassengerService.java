package com.fms.flight_management_system.service;

import com.fms.flight_management_system.model.Passengers;

import java.util.List;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 23/05/22
 */
public interface PassengerService {
	List<Passengers> getAllPassengers();

	Passengers getPassengerById(Long passengerId);

	Passengers savePassenger(Passengers passenger);

	void deletePassengerById(Long passengerId);

	void updatePassengerByDetails(String email, Long phoneNumber);
}
