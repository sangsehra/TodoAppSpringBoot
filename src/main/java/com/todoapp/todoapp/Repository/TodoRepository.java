package com.todoapp.todoapp.Repository;

import com.todoapp.todoapp.Entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
}
