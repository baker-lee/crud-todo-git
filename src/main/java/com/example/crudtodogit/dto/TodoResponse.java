package com.example.crudtodogit.dto;

import com.example.crudtodogit.entity.Todo;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TodoResponse {
    private Long id;
    private String title;
    private Long order;
    private Boolean completed;

    public TodoResponse(Todo todo){
        this.id = todo.getId();
        this.title = todo.getTitle();
        this.order = todo.getOrder();
        this.completed = todo.getCompleted();
    }
}
