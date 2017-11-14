package com.example.todo.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "spaces")
@AttributeOverride(name = "id", column = @Column(name = "column_id"))
public class Space extends AbstractPersistable<Long> {

	private String name;

	@OneToOne(fetch = FetchType.LAZY)
	private User user;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "space")
	private Set<Task> tasks;

	public String getName() {
		return name;
	}

	public Space setName(final String name) {
		this.name = name;
		return this;
	}

	public User getUser() {
		return user;
	}

	public Space setUser(final User user) {
		this.user = user;
		return this;
	}

	public Set<Task> getTasks() {
		return tasks;
	}

	public Space setTasks(final Set<Task> tasks) {
		this.tasks = tasks;
		return this;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		final Space space = (Space) o;

		return new EqualsBuilder()
				.append(name, space.name)
				.append(user, space.user)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
				.append(name)
				.append(user)
				.toHashCode();
	}
}
