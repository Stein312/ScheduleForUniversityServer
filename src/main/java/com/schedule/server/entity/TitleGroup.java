package com.schedule.server.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="titleGroup")
public class TitleGroup {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int id;
    @Column(name = "title", length = 30)
    private String title;
    @Column(name = "faculty", length = 120)
    private String faculty;

    public TitleGroup(String title, String faculty) {
        this.title = title;
        this.faculty = faculty;
    }

    public TitleGroup() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TitleGroup that = (TitleGroup) o;
        return Objects.equals(title, that.title) &&
                Objects.equals(faculty, that.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, faculty);
    }
}
