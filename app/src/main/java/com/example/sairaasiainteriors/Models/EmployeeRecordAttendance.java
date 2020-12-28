package com.example.sairaasiainteriors.Models;

public class EmployeeRecordAttendance {

    public String name, date, attendance, work;

    public EmployeeRecordAttendance() {
    }

    public EmployeeRecordAttendance(String name, String date, String attendance, String work) {
        this.name = name;
        this.date = date;
        this.attendance = attendance;
        this.work = work;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }


}
