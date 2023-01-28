package com.weki.todorestapi.todo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoResource {

    private final TodoRepository service;
    public TodoResource(TodoRepository service) {
        this.service = service;
    }

    @GetMapping("/users/{username}/todos")
    public List<Todo> retrieveTodos(@PathVariable String username) {
        return service.findAllByUsername(username);
    }

    @GetMapping("/users/{ignoredUsername}/todos/{todo_id}")
    public Todo retrieveTodo(@PathVariable String ignoredUsername, @PathVariable Integer todo_id) {
        return service.findById(todo_id).orElse(null);
    }

    @DeleteMapping("/users/{ignoredUsername}/todos/{todo_id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String ignoredUsername, @PathVariable Integer todo_id) {
        service.deleteById(todo_id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/users/{username}/todos/{todo_id}")
    public void updateATodo(@PathVariable String username, @PathVariable Integer todo_id, @RequestBody Todo todo) {
        todo.setId(todo_id);
        todo.setUsername(username);
        service.save(todo);
    }

    @PostMapping("/users/{username}/todos")
    public Todo createTodo(@PathVariable String username, @RequestBody Todo todo) {
        todo.setId(null);
        todo.setUsername(username);
        return service.save(todo);
    }
}
