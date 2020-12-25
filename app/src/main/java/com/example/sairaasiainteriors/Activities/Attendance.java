package com.example.sairaasiainteriors.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sairaasiainteriors.Models.EmployeeRecordAttendance;
import com.example.sairaasiainteriors.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Attendance extends AppCompatActivity {

    TextView empname;
    String currentDateandTime, current_name;
    Button confirm;
    TextInputEditText latetime;
    RadioGroup radioGroup;
    RadioButton radioButton;
    DatabaseReference databaseReference ,databaseReference1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

        empname = findViewById(R.id.emp_name);
        radioGroup = findViewById(R.id.radiogroup);
        confirm = findViewById(R.id.confirm);
        latetime = findViewById(R.id.late_time);

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        currentDateandTime = sdf.format(new Date());

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            current_name = bundle.getString("Username");
            databaseReference = FirebaseDatabase.getInstance().getReference("Employee").child(current_name).child("Attendance");
            empname.setText(current_name);
        }else {
            Toast.makeText(this, "Error accured", Toast.LENGTH_SHORT).show();
        }

        databaseReference1 = FirebaseDatabase.getInstance().getReference("EmployeeRecord").child(current_name).child(currentDateandTime);

        show();

    }

    public void show(){
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int radioId = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioId);
                EmployeeRecordAttendance employeeRecordAttendance = new EmployeeRecordAttendance(current_name, currentDateandTime, String.valueOf(radioButton.getText().toString()));
                databaseReference1.setValue(employeeRecordAttendance);
            }
        });

    }

}
