package com.fms.flight_management_system.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.persistence.Entity;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 19/05/22
 */
@Entity
@Getter
@Setter
public class Airport extends BaseEntity {

	private String airportCode;

	@Embedded
	private Address address;
}
