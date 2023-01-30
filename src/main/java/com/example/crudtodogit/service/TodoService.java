package com.example.crudtodogit.service;

import com.example.crudtodogit.dto.TodoRequest;
import com.example.crudtodogit.entity.Todo;
import com.example.crudtodogit.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository repository;

    public Todo create(TodoRequest request){
        Todo todo = new Todo();
        todo.setTitle(request.getTitle());
        todo.setOrder(request.getOrder());
        todo.setCompleted(request.getCompleted());
        return this.repository.save(todo);
    }

    public Todo searchById(Long id){
        return this.repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<Todo> searchAll() {
        return this.repository.findAll();
    }

    public Todo updateById(Long id, TodoRequest request){
        Todo todo = this.searchById(id);
        if(request.getTitle() != null) {
            todo.setTitle(request.getTitle());
        }
        if(request.getOrder() != null){
            todo.setOrder(request.getOrder());
        }
        if(request.getCompleted() != null){
            todo.setCompleted(request.getCompleted());
        }
        return this.repository.save(todo);
    }

    public void deleteById(Long id){
        this.repository.deleteById(id);
    }
}
