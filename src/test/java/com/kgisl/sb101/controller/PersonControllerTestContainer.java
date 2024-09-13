package com.kgisl.sb101.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import com.kgisl.sb101.entity.Person;
import com.kgisl.sb101.repository.PersonRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
// @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PersonControllerTestContainer {
    @Container
    @ServiceConnection

    static PostgreSQLContainer<?> postgresContainer = new PostgreSQLContainer<>(
            DockerImageName.parse("postgres:latest"));

    @Autowired
    PersonRepository repository;

    @LocalServerPort
    private Integer port;

    @Autowired
    TestRestTemplate restTemplate;

    @BeforeAll
    static void beforeAll() {
        postgresContainer.start();
    }

    @AfterAll
    static void afterAll() {
        postgresContainer.stop();
    }

    @BeforeEach
    void setUp() {

        // restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory("http://localhost:" + port));

        List<Person> persons = List.of(
                new Person(1, "The Turn of the Screw", "Henry James"),
                new Person(2, "American Gods", "Neil Gaiman"),
                new Person(3, "Dandelion Wine", "Ray Bradbury"));
        // repository.saveAll(persons);
    }

    @AfterEach
    void clear() {
        // repository.deleteAll();
    }

    @Test
    void connectionEstablished() {
        assertEquals(postgresContainer.isCreated(), true);
        assertEquals(postgresContainer.isRunning(), true);
    }

    @Disabled
    void shouldFindAllPersons() {

        Person[] persons = restTemplate.getForObject("/person", Person[].class);
        
        // assertEquals(3, persons.length);

    }
}
