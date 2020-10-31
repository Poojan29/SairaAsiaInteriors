package com.example.sairaasiainteriors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Attendance extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

        getSupportFragmentManager().beginTransaction().replace(R.id.attendance_layout, new EmployeeList()).commit();

    }
}