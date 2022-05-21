package com.fms.flight_management_system.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 19/05/22
 */
@Entity
@Getter
@Setter
public class Airpot extends BaseEntity {

	private String airportCode;

	private String city;

	private String state;

	private String country;

	private String postalCode;

	private String district;

	@OneToMany(mappedBy = "departureAirport", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	List<Flight> flights = new ArrayList<>();
}
