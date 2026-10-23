package org.example.formdemo;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonRepository {

    private final JdbcTemplate jdbc;
    private final PersonRowMapper rowMapper = new PersonRowMapper();

    public PersonRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Person> findAll() {
        String sql = "SELECT id, name, email, created_at FROM person ORDER BY id";
        return jdbc.query(sql, rowMapper);
    }

    public Person findById(int id) {
        String sql = "SELECT id, name, email, created_at FROM person WHERE id = ?";
        List<Person> result = jdbc.query(sql, rowMapper, id);
        return result.isEmpty() ? null : result.get(0); // returnér null hvis ikke fundet
    }

    public int save(Person p) {
        String sql = "INSERT INTO person (id, name, email) VALUES (?, ?, ?)";
        return jdbc.update(sql, p.getId(), p.getName(), p.getEmail());
    }

    public int update(Person p) {
        String sql = "UPDATE person SET name = ?, email = ? WHERE id = ?";
        return jdbc.update(sql, p.getName(), p.getEmail(), p.getId());
    }

    public int deleteById(int id) {
        String sql = "DELETE FROM person WHERE id = ?";
        return jdbc.update(sql, id);
    }

}
