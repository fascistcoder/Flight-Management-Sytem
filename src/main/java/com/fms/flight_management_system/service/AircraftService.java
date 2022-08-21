package com.fms.flight_management_system.service;

import com.fms.flight_management_system.model.Aircraft;

import java.util.List;
import java.util.Optional;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 03/06/22
 */
public interface AircraftService {
	List<Aircraft> getAllAircraft();

	Optional<Aircraft> getAircraftByAircraftModel(String modelNo);

	void saveAircraft(Aircraft aircraft);

	void deleteAircraft(String modelNo);
}
