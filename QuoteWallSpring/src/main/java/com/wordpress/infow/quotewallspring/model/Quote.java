package com.wordpress.infow.quotewallspring.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the quotes database table.
 * 
 */
@Entity
@Table (name = "quotes")
public class Quote implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (unique = true, nullable = false)
	private Integer id;

	@Column (nullable = false, length = 30)
	private String author;

	@Column (nullable = false)
	private Timestamp created;

	@Column (nullable = false, length = 300)
	private String text;

	public Quote() {
	}

	public Quote(String author, String text) {
		this.author = author;
		this.text = text;
		this.created = new Timestamp(Calendar.getInstance().getTimeInMillis());
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;

		result = (prime * result) + ((this.author == null) ? 0 : this.author.hashCode());
		result = (prime * result) + ((this.text == null) ? 0 : this.text.hashCode());

		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Quote)) {
			return false;
		}

		Quote quote = (Quote) obj;

		if (!this.author.equals(quote.author)) {
			return false;
		}

		if (!this.text.equals(quote.text)) {
			return false;
		}

		return true;
	}
}