package com.weki.todorestapi.todo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoResource {

    private final TodoService service;
    public TodoResource(TodoService service) {
        this.service = service;
    }

    @GetMapping("/users/{username}/todos")
    public List<Todo> retrieveTodos(@PathVariable String username) {
        return service.findByUsername(username);
    }

    @GetMapping("/users/{username}/todos/{todo_id}")
    public Todo retrieveTodo(@PathVariable String username, @PathVariable Integer todo_id) {
        return service.findById(todo_id);
    }

    @DeleteMapping("/users/{username}/todos/{todo_id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable Integer todo_id) {
        service.deleteById(todo_id);
        return ResponseEntity.noContent().build();
    }
}
