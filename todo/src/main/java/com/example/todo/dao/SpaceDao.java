package com.example.todo.dao;

import com.example.todo.entity.Space;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpaceDao extends JpaRepository<Space, Long> {
}
