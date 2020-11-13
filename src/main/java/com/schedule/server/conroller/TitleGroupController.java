package com.schedule.server.conroller;

import com.schedule.server.entity.Lesson;
import com.schedule.server.entity.TitleGroup;
import com.schedule.server.repository.LessonsRepository;
import com.schedule.server.service.TitleGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@RestController
public class TitleGroupController {
    @Autowired
    private final TitleGroupService service;
    @Autowired
    private LessonsRepository repository;

    public TitleGroupController(TitleGroupService service) {
        this.service = service;
    }

    @RequestMapping(value = "/titleGroup/getAll", method = RequestMethod.GET)
    @ResponseBody
    public List<TitleGroup> getAllReminders() {
        return service.getAll();
    }

    @RequestMapping(value = "/titleGroup/reload", method = RequestMethod.GET)
    @ResponseBody
    public String reload() {
        service.removeAll();
        HashSet<TitleGroup> set = new HashSet<TitleGroup>();
        List<Lesson> lessons = repository.findAll();
        for (Lesson lesson : lessons) {
            set.add(new TitleGroup(lesson.getGroup(),lesson.getFaculty()));
        }
        if (set.isEmpty())
            return "Error";
        for (TitleGroup group : set) {
            service.save(group);
        }
        return "Successful";

    }
}
