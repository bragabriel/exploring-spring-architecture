package io.github.bragabriel.springarchitecture.todos;

import org.springframework.stereotype.Component;

@Component
public class TodoValidator {

    private TodoRepository repository;

    public TodoValidator(TodoRepository repository){
        this.repository = repository;
    }

    public void validator(TodoEntity todo){
        if(existsTodoWithDescription(todo.getDescription())){
            throw new IllegalArgumentException("There is already a TODO with this description.");
        }
    }

    public boolean existsTodoWithDescription(String description){
        return repository.existsByDescription(description);
    }

}
