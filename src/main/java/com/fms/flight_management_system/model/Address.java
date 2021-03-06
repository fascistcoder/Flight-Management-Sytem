package com.fms.flight_management_system.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 21/05/22
 */
@Embeddable
@Setter
@Getter
public class Address {

	private String city;

	private String state;

	private String country;

	private String postalCode;

	private String district;
}
