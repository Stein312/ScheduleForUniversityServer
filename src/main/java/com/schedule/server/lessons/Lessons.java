package com.schedule.server.lessons;

import com.schedule.server.entity.Lesson;
import com.schedule.server.service.LessonsService;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Lessons {
    LessonsService service;

    public ArrayList<Lesson> getLessons() {
        return lessons;
    }

    ArrayList<Lesson> lessons=new ArrayList<Lesson>();
    HashMap<String, List<Lesson>> hashLessons= new HashMap<String, List<Lesson>>();
    public Lessons(XSSFWorkbook xssfWorkbook,String faculty){
        int n= xssfWorkbook.getNumberOfSheets()-1;
        for(int i=0;i<=n;i++){
            XSSFSheet xssfSheet=xssfWorkbook.getSheetAt(i);
            lessons.addAll(lessonsToList(xssfSheet,faculty));
        }

    }
    public void lessonsToDataBase(){
        for(Lesson lesson:lessons){
            service.save(lesson);
        }
    }

    private ArrayList<Lesson> lessonsToList(Sheet xlSh,String faculty){

        ArrayList<Lesson> lessons=new ArrayList<Lesson>();
        int i = 2;
        int j = 2;
        int iDate = 1;
        int jDate = 2;
        int m=1;
        String group = xlSh.getSheetName();
        if(xlSh.getRow(iDate).getCell(jDate).toString() == null){
            iDate+=15;
            i=iDate+1;

        }

        while(true){
            Lesson lesson=new Lesson();
            String title=xlSh.getRow(i).getCell(j).toString();
            lesson.setTitle(title);
            String date=xlSh.getRow(iDate).getCell(jDate).toString();
            lesson.setDate(date);
            String cabinet=xlSh.getRow(i).getCell(j+1).toString();
            lesson.setCabinet(cabinet);
            String nameTch=xlSh.getRow(i + 1).getCell(j).toString();
            lesson.setNameTch(nameTch);
            String day = xlSh.getRow(iDate).getCell(1).toString();
            lesson.setDay(day);
            String time = xlSh.getRow(i).getCell(0).toString();
            lesson.setTime(time);
            lesson.setGroup(group);
            lesson.setFaculty(faculty);
            lessons.add(lesson);
            if (m >= 7) {
                i += 1;
                iDate += 15;
                m = 0;
                if (xlSh.getRow(iDate)==null) {
                    i = 0;
                    iDate = 1;
                    jDate += 2;
                    j += 2;
                    if(xlSh.getRow(iDate).getCell(jDate).toString().equals("")){
                        break;
                    }
                }
            }
            i += 2;
            m++;
        }
        return lessons;
    }
}
