package io.github.bragabriel.springarchitecture.todos;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("todos")
public class TodoController {

    private TodoService service;

    public TodoController(TodoService service){
        this.service = service;
    }

    @PostMapping
    public TodoEntity save(@RequestBody TodoEntity todo){
        return this.service.save(todo);
    }
}
