package com.todoapp.todoapp.POJO;
import lombok.Data;
import lombok.Getter;
import org.joda.time.LocalDate;

@Data
public class Todo {
    private String task;
    private LocalDate dueDate;

}
