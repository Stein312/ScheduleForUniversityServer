package com.schedule.server.conroller;

public class MyThread implements Runnable {
private String path;
private String faculty;

    public MyThread(String path, String faculty) {
        this.path = path;
        this.faculty = faculty;
    }

    @Override
    public void run() {

    }
}
