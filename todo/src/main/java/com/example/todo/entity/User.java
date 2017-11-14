package com.example.todo.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

@Entity
@Table(name = "users")
@AttributeOverride(name = "id", column = @Column(name = "user_id"))
public class User extends AbstractPersistable<Long> {

	private String name;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
	private Space space;

	public String getName() {
		return name;
	}

	public User setName(final String name) {
		this.name = name;
		return this;
	}

	public Space getSpace() {
		return space;
	}

	public User setSpace(final Space space) {
		this.space = space;
		return this;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		final User user = (User) o;

		return new EqualsBuilder()
				.append(name, user.name)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
				.append(name)
				.toHashCode();
	}
}
