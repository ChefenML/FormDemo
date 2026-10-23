package org.example.formdemo;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonRowMapper implements RowMapper<Person> {

    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        Person p = new Person();
        p.setId(rs.getInt("id"));
        p.setName(rs.getString("name"));
        p.setTimestamp(rs.getString("created_at"));
        // Kolonnen kan være null/ikke til stede alt efter dit schema
        try {
            p.setEmail(rs.getString("email"));
        } catch (SQLException ignored) {
            // hvis kolonnen ikke findes, ignoreres det
        }
        return p;
    }
}
