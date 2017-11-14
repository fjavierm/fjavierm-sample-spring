package com.example.todo.dto;

import com.example.todo.entity.Category;
import com.example.todo.entity.Task;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CategoryDto implements Serializable {

	private String name;
	private List<Task> tasks;

	public static CategoryDto toDto(final Category category) {
		return new CategoryDto()
				.setName(category.getName())
				.setTasks(new ArrayList<>(category.getTasks()));
	}

	public String getName() {
		return name;
	}

	public CategoryDto setName(final String name) {
		this.name = name;
		return this;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public CategoryDto setTasks(final List<Task> tasks) {
		this.tasks = tasks;
		return this;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		final CategoryDto that = (CategoryDto) o;

		return new EqualsBuilder()
				.append(name, that.name)
				.append(tasks, that.tasks)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
				.append(name)
				.append(tasks)
				.toHashCode();
	}
}
