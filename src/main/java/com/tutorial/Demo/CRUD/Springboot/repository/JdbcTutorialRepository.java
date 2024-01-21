package com.tutorial.Demo.CRUD.Springboot.repository;

import com.tutorial.Demo.CRUD.Springboot.model.Tutorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcTutorialRepository implements TutorialRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(Tutorial tutorial) {
        return jdbcTemplate.update("INSERT INTO tutorials (title, description, published) VALUES(?,?,?)",
                tutorial.getTitle(), tutorial.getDescription(), tutorial.isPublished());
    }

    @Override
    public int update(Tutorial tutorial) {
        return jdbcTemplate.update("UPDATE tutorials SET title =?, description =?, published =? WHERE id =?",
                tutorial.getTitle(), tutorial.getDescription(), tutorial.isPublished(), tutorial.getId());
    }

    @Override
    public Tutorial findById(long id) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM tutorials WHERE id = ?",BeanPropertyRowMapper.newInstance(Tutorial.class), id);
        }
        //Data access exception thrown when a result was not of the expected size, for example when expecting a single row but getting 0 or more than 1 row.
        catch (IncorrectResultSizeDataAccessException e) {
//            System.out.println(e);
            return null;
        }
    }

    @Override
    public int deleteById(long id) {
        return jdbcTemplate.update("DELETE FROM tutorials WHERE id = ?", id);
    }

    @Override
    public List<Tutorial> findAll() {
        /*
        BeanPropertyRowMapper implements RowMapper that converts a table row into a new instance of the specified mapped target class (Tutorial).
         */
        return jdbcTemplate.query("SELECT * FROM tutorials;", BeanPropertyRowMapper.newInstance(Tutorial.class));
    }

    @Override
    public List<Tutorial> findByPublished(boolean published) {
        return jdbcTemplate.query("SELECT * FROM tutorials WHERE published = ?",
                BeanPropertyRowMapper.newInstance(Tutorial.class), published);
    }

    @Override
    public List<Tutorial> findByTitleContaining(String title) {
        String query = "SELECT * FROM tutorials WHERE title ILIKE '%" + title + "%'";
        return jdbcTemplate.query(query,
                BeanPropertyRowMapper.newInstance(Tutorial.class));
    }

    @Override
    public int deleteAll() {
        return jdbcTemplate.update("DELETE FROM tutorials");
    }
}
