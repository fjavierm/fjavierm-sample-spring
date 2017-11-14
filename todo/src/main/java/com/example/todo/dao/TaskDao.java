package com.example.todo.dao;

import com.example.todo.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskDao extends JpaRepository<Task, Long> {
}
