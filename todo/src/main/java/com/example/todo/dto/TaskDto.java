package com.example.todo.dto;

import com.example.todo.entity.Category;
import com.example.todo.entity.Space;
import com.example.todo.entity.Task;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class TaskDto implements Serializable {

	private String description;
	private Boolean done;
	private Long spaceId;
	private List<Long> categoryIds;

	public static TaskDto toDto(final Task task) {
		return new TaskDto()
				.setDescription(task.getDescription())
				.setDone(task.getDone())
				.setSpaceId(task.getSpace().getId())
				.setCategoryIds(task.getCategories().stream().map(Category::getId).collect(Collectors.toList()));
	}

	public String getDescription() {
		return description;
	}

	public TaskDto setDescription(final String description) {
		this.description = description;
		return this;
	}

	public Boolean getDone() {
		return done;
	}

	public TaskDto setDone(final Boolean done) {
		this.done = done;
		return this;
	}

	public Long getSpaceId() {
		return spaceId;
	}

	public TaskDto setSpaceId(final Long spaceId) {
		this.spaceId = spaceId;
		return this;
	}

	public List<Long> getCategoryIds() {
		return categoryIds;
	}

	public TaskDto setCategoryIds(final List<Long> categoryIds) {
		this.categoryIds = categoryIds;
		return this;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		final TaskDto taskDto = (TaskDto) o;

		return new EqualsBuilder()
				.append(description, taskDto.description)
				.append(done, taskDto.done)
				.append(spaceId, taskDto.spaceId)
				.append(categoryIds, taskDto.categoryIds)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
				.append(description)
				.append(done)
				.append(spaceId)
				.toHashCode();
	}
}
