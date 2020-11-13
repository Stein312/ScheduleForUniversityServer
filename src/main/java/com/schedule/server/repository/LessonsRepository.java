package com.schedule.server.repository;

import com.schedule.server.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LessonsRepository extends JpaRepository<Lesson, Long> {

}
