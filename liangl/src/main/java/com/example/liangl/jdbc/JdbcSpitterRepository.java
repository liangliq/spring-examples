package com.example.liangl.jdbc;

import com.example.liangl.data.SpitterRepository;
import com.example.liangl.model.Spitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by cpekl-ddim-2 on 11/12/18.
 */
public class JdbcSpitterRepository implements SpitterRepository {

    private JdbcTemplate jdbcTemplate;

    private static final String INSERT_SPITTER =
            "insert into spitter {firstname, lastname, password, username} values (?,?,?,?)";
    private static final String STLECT_SPITTER_BY_ID =
            "select id, firstname, lastname, username from spitter where id = ?";

    @Autowired
    public JdbcSpitterRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Spitter save(Spitter spitter) {
        Long id = spitter.getId();
        if (id == null) {
            addSpitter(spitter);
            return new Spitter(spitter.getId(), spitter.getFirstname(), spitter.getLastname(), spitter.getUsername(), spitter.getPassword());
        } else {
            jdbcTemplate.update("update spitter set firstname=?, lastname=?, username=?, password=?, where id=?",
                    spitter.getFirstname(),
                    spitter.getLastname(),
                    spitter.getUsername(),
                    spitter.getPassword(),
                    id);
        }
        return spitter;
    }

    @Override
    public Spitter findOne(Long id) {
        return jdbcTemplate.queryForObject(STLECT_SPITTER_BY_ID, new SpitterRowMapper(), id);
    }

    @Override
    public Spitter findByUsername(String username) {
        return null;
    }

    @Override
    public List<Spitter> findAll() {
        return null;
    }

    private void addSpitter(Spitter spitter) {

        jdbcTemplate.update(INSERT_SPITTER, spitter.getFirstname(),
                spitter.getLastname(), spitter.getUsername(), spitter.getPassword());

    }

    private static final class SpitterRowMapper implements RowMapper<Spitter> {

        @Override
        public Spitter mapRow(ResultSet resultSet, int i) throws SQLException {
            return new Spitter(
                    resultSet.getLong("id"),
                    resultSet.getString("firstname"),
                    resultSet.getString("lastname"),
                    resultSet.getString("username"),
                    resultSet.getString("password"));
        }
    }

}
