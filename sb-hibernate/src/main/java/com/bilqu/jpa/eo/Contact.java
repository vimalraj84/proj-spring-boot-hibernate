package com.bilqu.jpa.eo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.envers.Audited;


@Entity
@Audited
public class Contact extends AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "con_id_seq")
	@SequenceGenerator(name = "con_id_seq", sequenceName = "CON_ID_SEQ", initialValue = 1, allocationSize = 1)
	private long conId;

	@Column
	private String conType;

	@Column
	private String conDtl;

	public Contact() {

	}

	public Contact(long conId, String conType, String conDtl) {
		this.conId = conId;
		this.conType = conType;
		this.conDtl = conDtl;
	}

	public long getConId() {
		return conId;
	}

	public void setConId(long conId) {
		this.conId = conId;
	}

	public String getConType() {
		return conType;
	}

	public void setConType(String conType) {
		this.conType = conType;
	}

	public String getConDtl() {
		return conDtl;
	}

	public void setConDtl(String conDtl) {
		this.conDtl = conDtl;
	}

	@Override
	public String toString() {
		return String.format("Contact [conId=%s, conType=%s, conDtl=%s]", conId, conType, conDtl);
	}
}
