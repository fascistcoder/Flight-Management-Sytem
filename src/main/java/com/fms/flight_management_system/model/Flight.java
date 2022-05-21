package com.fms.flight_management_system.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 19/05/22
 */
@Getter
@Setter
@Entity
public class Flight extends BaseEntity {
	private String flightNumber;

	private LocalDate departureDate;

	private LocalDate arrivalDate;

	private LocalTime departureTime;

	private double flightCharge;

	@ManyToOne(cascade = CascadeType.ALL)
	private Aircraft aircraft;

	@ManyToOne(cascade = CascadeType.ALL)
	private Airport departureAirport;

	@ManyToOne(cascade = CascadeType.ALL)
	private Airport destinationAirport;
}
