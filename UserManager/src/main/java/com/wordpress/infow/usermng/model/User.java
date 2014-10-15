package com.wordpress.infow.usermng.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "USERS")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class User {

	private int id;
	private String username;
	private String password;
	private String email;

	@Id
	@GeneratedValue
	@Column(name = "USER_ID")
	public int getId() {

		return this.id;
	}

	public void setId(int id) {

		this.id = id;
	}

	public String getUsername() {

		return this.username;
	}

	public void setUsername(String username) {

		this.username = username;
	}

	public String getPassword() {

		return this.password;
	}

	public void setPassword(String password) {

		this.password = password;
	}

	public String getEmail() {

		return this.email;
	}

	public void setEmail(String email) {

		this.email = email;
	}

}
