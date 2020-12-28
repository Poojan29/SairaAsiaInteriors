package com.example.sairaasiainteriors.Models;

public class PersonDataModel {

    public String attendance, date, work;


    public PersonDataModel(String attendance, String date, String work) {
        this.attendance = attendance;
        this.date = date;
        this.work = work;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return work;
    }

    public void setName(String name) {
        this.work = name;
    }
}
