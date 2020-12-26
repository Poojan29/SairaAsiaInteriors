package com.example.sairaasiainteriors.Models;

public class PersonDataModel {

    public String attendance, date, name;

    private PersonDataModel(String attendance, String date, String name) {
        this.attendance = attendance;
        this.date = date;
        this.name = name;
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
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PersonDataModel() {
    }
}
