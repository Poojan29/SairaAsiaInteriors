package com.example.sairaasiainteriors.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sairaasiainteriors.Models.EmployeeRecordAttendance;
import com.example.sairaasiainteriors.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Attendance extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView empname;
    String currentDateandTime, current_name, text;
    Button confirm;
    RadioGroup radioGroup;
    RadioButton radioButton;
    DatabaseReference databaseReference ,databaseReference1;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

        empname = findViewById(R.id.emp_name);
        radioGroup = findViewById(R.id.radiogroup);
        confirm = findViewById(R.id.confirm);
        spinner = findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.planets_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

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

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        text = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        Toast.makeText(this, "Nothing Selected.", Toast.LENGTH_SHORT).show();
    }

    public void show(){
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int radioId = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioId);

                if (text==null){
                    Toast.makeText(Attendance.this, "Select your work.", Toast.LENGTH_SHORT).show();
                }else{

                EmployeeRecordAttendance employeeRecordAttendance = new EmployeeRecordAttendance(current_name, currentDateandTime, radioButton.getText().toString(), text);
                databaseReference1.setValue(employeeRecordAttendance);

                startActivity(new Intent(getApplicationContext(), EmployeeList.class));
                finish();
                }
            }
        });

    }
}
