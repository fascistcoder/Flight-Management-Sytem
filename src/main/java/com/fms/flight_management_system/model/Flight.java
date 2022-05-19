package com.fms.flight_management_system.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

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

	@ManyToOne
	private Airpot departureAirport;

	@ManyToOne
	private Airpot destinationAirport;

	private LocalDate departureDate;

	private LocalDate arrivalDate;

	private LocalTime departureTime;

	private double flightCharge;

	@ManyToOne
	private Aircraft aircraft;

	@OneToMany(mappedBy = "flight")
	List<Passengers> passengers = new ArrayList<>();
}
