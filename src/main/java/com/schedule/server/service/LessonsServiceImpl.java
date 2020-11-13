package com.schedule.server.service;

import com.schedule.server.entity.Lesson;
import com.schedule.server.repository.LessonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LessonsServiceImpl implements LessonsService {
    @Autowired
    private LessonsRepository repository;
    @Override
    public List<Lesson> getAll() {
        return repository.findAll();
    }

    @Override
    public Lesson getByID(long id) {
        return repository.getOne(id);
    }

    @Override
    public Lesson save(Lesson lesson) {
        return repository.saveAndFlush(lesson);
    }



    @Override
    public void remove(long id) {
        repository.deleteById(id);
    }

    @Override
    public void removeAll() {
        repository.deleteAll();
    }
}
