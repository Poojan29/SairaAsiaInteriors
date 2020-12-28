package com.example.sairaasiainteriors.Models;

public class DailyRecordModel {

     String name, work, attendance;

    public DailyRecordModel() {
    }

    public DailyRecordModel(String name, String work, String attendance) {
        this.name = name;
        this.work = work;
        this.attendance = attendance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }




}
