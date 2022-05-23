package com.fms.flight_management_system.rest.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 21/05/22
 */
@Getter
@Setter
public class PassengerRequestDto {
	private String firstName;

	private String lastName;

	@NotNull
	@Email
	private String email;

	@NotNull
	@Min(10000000)
	@Max(999999999999L)
	private Long phoneNumber;

	private String city;

	private String state;

	private String country;

	private String postalCode;

	private String district;
}
