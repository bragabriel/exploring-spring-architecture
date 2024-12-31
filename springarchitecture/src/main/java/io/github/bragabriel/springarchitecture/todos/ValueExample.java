package io.github.bragabriel.springarchitecture.todos;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ValueExample {

    @Value("${app.config.myvar}")
    private String var;

    public void printVar(){
        System.out.println(var);
    }
}
