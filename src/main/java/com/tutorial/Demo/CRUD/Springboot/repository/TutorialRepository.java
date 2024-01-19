package com.tutorial.Demo.CRUD.Springboot.repository;

import com.tutorial.Demo.CRUD.Springboot.model.Tutorial;

import java.util.List;

public interface TutorialRepository {


    int save(Tutorial book) ;

    int update(Tutorial book);

    Tutorial findById(long id);

    int deleteById(long id);

    List<Tutorial> findAll();

    List<Tutorial> findByPublished(boolean published);

    List<Tutorial> findByTitleContaining(String title);

    int deleteAll();
}
