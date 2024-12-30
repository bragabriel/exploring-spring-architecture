package io.github.bragabriel.springarchitecture.todos;

import jakarta.persistence.EntityManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DependencyInjectionExample {
    public static void main(String[] args) throws SQLException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("url");
        dataSource.setUsername("user");
        dataSource.setPassword("password");

        Connection connection = dataSource.getConnection();

        EntityManager entityManager = null;

        TodoRepository repository = null; //new SimpleJpaRepository<TodoEntity, Integer>();
        TodoValidator validator = new TodoValidator(repository);
        EmailSender sender = new EmailSender();

        //Service usage without dependency injection (old way xD)
        TodoService todoService = new TodoService(repository, validator, sender);
    }
}
