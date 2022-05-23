package com.fms.flight_management_system.repository;

import com.fms.flight_management_system.model.Passengers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 23/05/22
 */
public interface PassengerRepository extends JpaRepository<Passengers, UUID> {

	Optional<Passengers> findPassengersByEmailAndPhoneNumber(String email, Long phoneNumber);

	Optional<Passengers> findByEmail(String email);

	Optional<Passengers> findPassengersByPhoneNumber(Long phoneNumber);

	Optional<Passengers> findPassengersByPassengerUniqueId(String input);
}
