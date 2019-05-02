package com.bilqu.jpa.eo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
	private Long id;

	@Column
	@Enumerated(EnumType.STRING)
	private ContactType conType;

	@Column
	private String conDtl;

	public Contact() {

	}

	public Contact(long conId, ContactType conType, String conDtl) {
		this.id = conId;
		this.conType = conType;
		this.conDtl = conDtl;
	}

	public long getConId() {
		return id;
	}

	public void setConId(long conId) {
		this.id = conId;
	}

	public ContactType getConType() {
		return conType;
	}

	public void setConType(ContactType conType) {
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
		return String.format("Contact [conId=%s, conType=%s, conDtl=%s]", id, conType, conDtl);
	}
}
