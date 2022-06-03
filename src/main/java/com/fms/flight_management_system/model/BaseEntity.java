package com.fms.flight_management_system.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 19/05/22
 */
@MappedSuperclass
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseEntity {

	@Id
	@JsonIgnore
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(length = 36, columnDefinition = "UUID", updatable = false, nullable = false)
	protected UUID id;

	@JsonIgnore
	Calendar calendar = Calendar.getInstance();

	@Column(
			nullable = false,
			updatable = false
	)
	@CreatedDate
	@DateTimeFormat(
			iso = DateTimeFormat.ISO.DATE_TIME
	)
	@JsonIgnore
	protected Date created = calendar.getTime();

	@LastModifiedDate
	@DateTimeFormat(
			iso = DateTimeFormat.ISO.DATE_TIME
	)
	@JsonIgnore
	protected Date lastUpdated;


	@PrePersist
	@PreUpdate
	public void onUpdate() {
		if (this.created == null) {
			this.created = calendar.getTime();
		}
		this.lastUpdated = calendar.getTime();
	}

}
