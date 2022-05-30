package com.fms.flight_management_system.service.impl;

import com.fms.flight_management_system.model.Airport;
import com.fms.flight_management_system.repository.AirportRepository;
import com.fms.flight_management_system.service.AirportService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 24/05/22
 */
@AllArgsConstructor
@Slf4j
@Service
public class AirportServiceImpl implements AirportService {

	private final AirportRepository airportRepository;

	@Override public List<Airport> getAllAirports() {
		return airportRepository.findAll();
	}

	@Override public Optional<Airport> getAirportByAirportCode(String airportCode) {
		return Optional.empty();
	}

	@Override public void saveAirport(Airport airport) {

	}

	@Override public void deleteAirport(String airportCode) {

	}
}
