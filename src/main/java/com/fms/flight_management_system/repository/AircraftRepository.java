package com.fms.flight_management_system.repository;

import com.fms.flight_management_system.model.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 03/06/22
 */
public interface AircraftRepository extends JpaRepository<Aircraft, UUID> {

	Optional<Aircraft> findAircraftByModel(String modelNo);

	void deleteAircraftByModel(String modelNo);
}
