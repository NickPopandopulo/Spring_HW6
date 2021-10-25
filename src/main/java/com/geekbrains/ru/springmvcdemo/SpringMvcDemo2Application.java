package com.geekbrains.ru.springmvcdemo;

import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMvcDemo2Application {

    public static void main(String[] args) {
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:postgresql://localhost:5432/simple-app-test", "postgres", "postgres")
                .load();
        flyway.migrate();

        SpringApplication.run(SpringMvcDemo2Application.class, args);
    }

}
