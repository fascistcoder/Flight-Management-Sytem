package com.fms.flight_management_system.repository;

import com.fms.flight_management_system.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 24/05/22
 */
public interface AirportRepository extends JpaRepository<Airport, UUID> {
	void deleteAirportByAirportCode(String airportCode);
}
