package com.bilqu.jpa.eo;

import java.time.LocalDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass  //used to inherit attributes from base/super class
@EntityListeners({AuditingEntityListener.class}) //enables auditing
//TODO: Break circular dependency due to the bi-directional relationships between the EO.
//@JsonIdentityInfo
//@JsonBackReference
//@JsonManagedReference
public abstract class AbstractEntity {
	//The LocalDateTime class represents a date-time. There is no representation of a time-zone.

	// @CreatedDate //Used for Auditing capture when the entity was created. Spring
	// Data JPA will take care of this.
	@CreationTimestamp
	@ColumnDefault("CURRENT_TIMESTAMP")
	private LocalDateTime createdTs; // since Hibernate 5.2.3

	// @LastModifiedDate //capture when the entity was updated
	@UpdateTimestamp
	@ColumnDefault("CURRENT_TIMESTAMP")
	private LocalDateTime updatedTs; // since Hibernate 5.2.3

	@LastModifiedBy
	private String updatedBy;

}
