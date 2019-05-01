package com.bilqu.jpa.eo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.envers.Audited;

@Entity
@Audited
public class Contact extends AbstractEntity {

	@Id
	private long con_id;

	@Column
	private String con_type;

	@Column
	private String con_dtl;

	public Contact() {

	}

	public Contact(long con_id, String con_type, String con_dtl) {
		this.con_id = con_id;
		this.con_type = con_type;
		this.con_dtl = con_dtl;
	}

	public long getCon_id() {
		return con_id;
	}

	public void setCon_id(long con_id) {
		this.con_id = con_id;
	}

	public String getCon_type() {
		return con_type;
	}

	public void setCon_type(String con_type) {
		this.con_type = con_type;
	}

	public String getCon_dtl() {
		return con_dtl;
	}

	public void setCon_dtl(String con_dtl) {
		this.con_dtl = con_dtl;
	}

	@Override
	public String toString() {
		return String.format("Contact [con_id=%s, con_type=%s, con_dtl=%s]", con_id, con_type, con_dtl);
	}

}
