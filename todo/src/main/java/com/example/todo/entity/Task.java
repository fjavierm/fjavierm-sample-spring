package com.example.todo.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tasks")
@AttributeOverride(name = "id", column = @Column(name = "task_id"))
public class Task extends AbstractPersistable<Long> {

	private String description;
	private Boolean done;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "space_id", nullable = false)
	private Space space;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "task_categories", joinColumns = {
			@JoinColumn(name = "task_id", nullable = false, updatable = false)},
			inverseJoinColumns = {@JoinColumn(name = "category_id",
					nullable = false, updatable = false)})
	private Set<Category> categories;

	public Task() {
		this.done = Boolean.FALSE;
	}

	public String getDescription() {
		return description;
	}

	public Task setDescription(final String description) {
		this.description = description;
		return this;
	}

	public Boolean getDone() {
		return done;
	}

	public Task setDone(final Boolean done) {
		this.done = done;
		return this;
	}

	public Space getSpace() {
		return space;
	}

	public Task setSpace(final Space space) {
		this.space = space;
		return this;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public Task setCategories(final Set<Category> categories) {
		this.categories = categories;
		return this;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		final Task task = (Task) o;

		return new EqualsBuilder()
				.append(description, task.description)
				.append(done, task.done)
				.append(space, task.space)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
				.append(description)
				.append(done)
				.append(space)
				.toHashCode();
	}
}
