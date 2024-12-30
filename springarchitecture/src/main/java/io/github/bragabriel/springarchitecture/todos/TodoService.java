package io.github.bragabriel.springarchitecture.todos;

import org.hibernate.type.descriptor.java.spi.BasicCollectionJavaType;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TodoService {

    private TodoRepository repository;
    private TodoValidator validator;
    private EmailSender mailSender;

    public TodoService(TodoRepository todoRepository, TodoValidator validator, EmailSender sender){
        this.repository = todoRepository;
        this.validator = validator;
        this.mailSender = sender;
    }

    public TodoEntity save(TodoEntity todo){
        try{
            validator.validator(todo);
            return repository.save(todo);
        }catch (IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }

    public void updateStatus(TodoEntity todo){
        repository.save(todo);
        String status = todo.getDone() == Boolean.TRUE ? "Completed" : "Not completed";
        mailSender.send("Todo " + todo.getDescription() + " has been updated and is " + status);
    }



}
