package com.fms.flight_management_system.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 19/05/22
 */
@Getter
@Entity
@Setter
public class Passengers extends BaseEntity {

	private String firstName;

	private String lastName;

	@NotNull
	private Long phoneNumber;

	@Email
	@NotNull
	private String email;

	private String address;

	@ManyToOne
	private Flight flight;
}
