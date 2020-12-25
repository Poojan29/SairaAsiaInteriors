package com.example.sairaasiainteriors.Models;

public class EmployeeRecordAttendance {

    public String name, date, attendance;

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

    public EmployeeRecordAttendance() {
    }

    public EmployeeRecordAttendance(String name, String date, String attendance) {
        this.name = name;
        this.date = date;
        this.attendance = attendance;
    }
}
