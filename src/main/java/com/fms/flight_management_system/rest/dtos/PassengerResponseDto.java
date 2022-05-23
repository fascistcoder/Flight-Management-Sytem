package com.fms.flight_management_system.rest.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 23/05/22
 */
@Getter
@Setter
@Builder
public class PassengerResponseDto {
	private String firstName;

	private String lastName;

	private String email;

	private Long phoneNumber;

	private String passengerUniqueId;
}
