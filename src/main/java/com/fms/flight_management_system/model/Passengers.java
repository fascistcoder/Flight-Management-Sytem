package com.fms.flight_management_system.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 19/05/22
 */
@Getter
@Entity
@Setter
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "email" }) })
public class Passengers extends BaseEntity {

	private String firstName;

	private String lastName;

	@NotNull
	private Long phoneNumber;

	@Column(nullable = false)
	private String email;

	@Embedded
	private Address address;

	@ManyToOne(cascade = CascadeType.ALL)
	private Flight flight;
}
