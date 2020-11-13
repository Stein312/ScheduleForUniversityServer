package com.schedule.server.service;

import com.schedule.server.entity.Lesson;

import java.util.List;

public interface LessonsService {
    List<Lesson> getAll();
    Lesson getByID(long id);
    Lesson save(Lesson lesson);

    void remove(long id);
    void removeAll();
}
