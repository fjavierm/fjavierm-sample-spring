package com.example.todo.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "categories")
@AttributeOverride(name = "id", column = @Column(name = "category_id"))
public class Category extends AbstractPersistable<Long> {

	private String name;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "categories")
	private Set<Task> tasks;

	public String getName() {
		return name;
	}

	public Category setName(final String name) {
		this.name = name;
		return this;
	}

	public Set<Task> getTasks() {
		return tasks;
	}

	public Category setTasks(final Set<Task> tasks) {
		this.tasks = tasks;
		return this;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		final Category category = (Category) o;

		return new EqualsBuilder()
				.appendSuper(super.equals(o))
				.append(name, category.name)
				.append(tasks, category.tasks)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
				.appendSuper(super.hashCode())
				.append(name)
				.append(tasks)
				.toHashCode();
	}
}
