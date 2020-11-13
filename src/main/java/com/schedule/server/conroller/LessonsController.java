package com.schedule.server.conroller;

import com.schedule.server.entity.Lesson;
import com.schedule.server.lessons.Lessons;
import com.schedule.server.service.LessonsService;
import com.schedule.server.service.TitleGroupService;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@RestController
public class LessonsController {
    @Autowired
    private final LessonsService service;


    public LessonsController(LessonsService service) {
        this.service = service;
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public List<Lesson> getAllLesson(){
        return service.getAll();
    }
    @RequestMapping(value = "/faculty/{faculty}", method = RequestMethod.GET)
    @ResponseBody
    public List<Lesson> getFacultyLesson(@PathVariable String faculty){
        ArrayList<Lesson> lessons=new ArrayList<Lesson>();
       for(Lesson lesson: service.getAll()){
           if(lesson.getFaculty().equals(faculty)){
                lessons.add(lesson);
           }
       }
       return lessons;

    }
    @RequestMapping(value = "/reload", method = RequestMethod.GET)
    @ResponseBody
    public String reload(){
        service.removeAll();
        String path="C:\\Users\\bovae\\IdeaProjects\\ScheduleForUniversityServer\\src\\main\\resources\\FPMiI_1.xlsx";
        String faculty="Факультет прикладной математики и информатики";
        if (lessonToDataBase(path,faculty)) return "Error";
        path="C:\\Users\\bovae\\IdeaProjects\\ScheduleForUniversityServer\\src\\main\\resources\\FIYA.xlsx";
        faculty="Факультет иностранных языков";
        if (lessonToDataBase(path,faculty)) return "Error";
        path="C:\\Users\\bovae\\IdeaProjects\\ScheduleForUniversityServer\\src\\main\\resources\\FPiP.xlsx";
        faculty="Факультет психологии и педагогики";
        if (lessonToDataBase(path,faculty)) return "Error";
        path="C:\\Users\\bovae\\IdeaProjects\\ScheduleForUniversityServer\\src\\main\\resources\\FE.xlsx";
        faculty="Факультет экономики";
        if (lessonToDataBase(path,faculty)) return "Error";
        path="C:\\Users\\bovae\\IdeaProjects\\ScheduleForUniversityServer\\src\\main\\resources\\FSiJ.xlsx";
        faculty="Факультет юриспруденции";
        if (lessonToDataBase(path,faculty)) return "Error";
        path="C:\\Users\\bovae\\IdeaProjects\\ScheduleForUniversityServer\\src\\main\\resources\\FYU.xlsx";
        faculty="Факультет социологии и журналистики";
        if (lessonToDataBase(path,faculty)) return "Error";
        return "Successful";
    }
    private Boolean  lessonToDataBase(String path,String faculty){
        FileInputStream file;
        try {
            file = new FileInputStream(new File(path));
            XSSFWorkbook xssfWorkbook=new XSSFWorkbook(file);
            Lessons lessons=new Lessons(xssfWorkbook,faculty);
            for (Lesson lesson:lessons.getLessons()){
                service.save(lesson);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return true;
        }
        return false;
    }


    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Lesson getReminder(@PathVariable() long id){
        return service.getByID(id);
    }

    @RequestMapping(value = "/reminders", method = RequestMethod.POST)
    @ResponseBody
    public Lesson saveRemind(@RequestBody Lesson lesson){
        return service.save(lesson);
    }


    @RequestMapping(value = "/reminders/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteRemind(@PathVariable() long id){
        service.remove(id);
    }
}
