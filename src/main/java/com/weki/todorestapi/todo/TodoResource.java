package com.weki.todorestapi.todo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
