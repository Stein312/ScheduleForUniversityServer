package com.schedule.server;

import com.schedule.server.lessons.Lessons;
import com.schedule.server.service.LessonsService;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class test {

    public static void main(String[] args) {
        FileInputStream file;

        try {
            file = new FileInputStream(test.class.getResource("/FPMiI_1.xlsx").getPath());
            XSSFWorkbook xssfWorkbook=new XSSFWorkbook(file);
            Lessons lessons=new Lessons(xssfWorkbook,"Факультет математики и информатики");
            System.out.println(lessons.getLessons().get(0).toString());
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        System.out.println(test.class.getResource("/FPMiI_1.xlsx").getPath());
        System.out.println("Successful");
    }
}
