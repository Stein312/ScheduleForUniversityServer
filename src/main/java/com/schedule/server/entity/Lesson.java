package com.schedule.server.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "schedule")
public class Lesson {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;
    @Column(name = "title", length = 120)
    private String title;
    @Column(name = "faculty", length = 120)
    private String faculty;
    @Column(name = "date", length = 30)
    private String date;
    @Column(name = "cab", length = 50)
    private String cabinet;
    @Column(name = "grp", length = 30)
    private String group;
    @Column(name = "nametch", length = 30)
    private String nameTch;
    @Column(name = "day", length = 30)
    private String day;
    @Column(name = "time", length = 30)
    private String time;


    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCabinet() {
        return cabinet;
    }

    public void setCabinet(String cabinet) {
        this.cabinet = cabinet;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNameTch() {
        return nameTch;
    }

    public void setNameTch(String nameTch) {
        this.nameTch = nameTch;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
