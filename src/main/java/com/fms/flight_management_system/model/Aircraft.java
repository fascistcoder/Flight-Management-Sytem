package com.fms.flight_management_system.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 19/05/22
 */
@Getter
@Setter
@Entity
public class Aircraft extends BaseEntity {

	private String manufacturer;

	private String model;

	private int numberOfSeats;
}
