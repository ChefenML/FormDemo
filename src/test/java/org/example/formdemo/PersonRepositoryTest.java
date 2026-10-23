package org.example.formdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

@SpringBootTest
@ActiveProfiles("test")
@Sql(scripts = "classpath:h2init.sql",executionPhase = BEFORE_TEST_METHOD)
class PersonRepositoryTest {

    @Autowired
    private PersonRepository repo;



    @Test
    void findAll() {
        List<Person> all = repo.findAll();

        assertThat(all).isNotNull();
        assertThat(all.size()).isEqualTo(2);
        assertThat(all.get(0).getName()).isEqualTo("Alice");
        assertThat(all.get(1).getName()).isEqualTo("Bob");
        System.out.println(all.getFirst().getTimestamp());
        System.out.println(all.getLast().getTimestamp());
    }

    @Test
    void save() {
        repo.save(new Person("Mikkel",3));
        var mikkel = repo.findById(3);
        assertThat(mikkel).isNotNull();
        assertThat(mikkel.getName()).isEqualTo("Mikkel");
        System.out.println(mikkel.getTimestamp());
    }
}