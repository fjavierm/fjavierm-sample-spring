package com.example.todo.dto;

import com.example.todo.entity.Space;
import com.example.todo.entity.Task;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class SpaceDto implements Serializable {

	private String name;
	private Long userId;
	private List<Long> taskIds;

	public static SpaceDto toDto(final Space space) {
		return new SpaceDto()
				.setName(space.getName())
				.setUserId(space.getUser().getId())
				.setTaskIds(space.getTasks().stream().map(Task::getId).collect(Collectors.toList()));
	}

	public String getName() {
		return name;
	}

	public SpaceDto setName(final String name) {
		this.name = name;
		return this;
	}

	public Long getUserId() {
		return userId;
	}

	public SpaceDto setUserId(final Long userId) {
		this.userId = userId;
		return this;
	}

	public List<Long> getTaskIds() {
		return taskIds;
	}

	public SpaceDto setTaskIds(final List<Long> taskIds) {
		this.taskIds = taskIds;
		return this;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		final SpaceDto spaceDto = (SpaceDto) o;

		return new EqualsBuilder()
				.append(name, spaceDto.name)
				.append(userId, spaceDto.userId)
				.append(taskIds, spaceDto.taskIds)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
				.append(name)
				.append(userId)
				.append(taskIds)
				.toHashCode();
	}
}
