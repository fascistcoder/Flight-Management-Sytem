package com.fms.flight_management_system.service.impl;

import com.fms.flight_management_system.model.Aircraft;
import com.fms.flight_management_system.repository.AircraftRepository;
import com.fms.flight_management_system.service.AircraftService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 03/06/22
 */
@AllArgsConstructor
@Slf4j
@Service
public class AircraftServiceImpl implements AircraftService {

	private final AircraftRepository aircraftRepository;

	@Override public List<Aircraft> getAllAircraft() {

		log.info("Displaying all the Aircraft");

		return aircraftRepository.findAll();
	}

	@Override public Optional<Aircraft> getAircraftByAircraftModel(String modelNo) {

		log.info("Find the aircraft by aircraft model {} ", modelNo);

		return aircraftRepository.findAircraftByModel(modelNo);
	}

	@Override public void saveAircraft(Aircraft aircraft) {
		Optional<Aircraft> aircraftOptional = getAircraftByAircraftModel(aircraft.getModel());

		if(aircraftOptional.isPresent()){
			log.info("Aircraft already present model {} ", aircraftOptional.get().getModel());
			return;
		}

		log.info("Aircraft had been saved {} ", aircraft.getModel());
		aircraftRepository.save(aircraft);
	}

	@Override public void deleteAircraft(String modelNo) {

		Optional<Aircraft> aircraftOptional = getAircraftByAircraftModel(modelNo);

		if(aircraftOptional.isPresent()){
			log.info("Aircaft found by model no {} ", modelNo);
			aircraftRepository.deleteAircraftByModel(modelNo);
		}
	}
}
