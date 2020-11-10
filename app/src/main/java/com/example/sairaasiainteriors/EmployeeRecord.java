package com.example.sairaasiainteriors;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EmployeeRecord extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    String name;
    RadioGroup radioGroup;
    RadioButton radioButton1, radioButton2, radioButton3, radioButton4;
    DatabaseReference databaseReference;
    String index;

    public EmployeeRecord() {

    }

    public EmployeeRecord(String name) {
        this.name = name;
//        this.radioGroup = radioGroup;
//        this.radioButton1 = radioButton1;
//        this.radioButton2 = radioButton2;
//        this.radioButton3 = radioButton3;
//        this.radioButton4 = radioButton4;
    }

    public static EmployeeRecord newInstance(String param1, String param2) {
        EmployeeRecord fragment = new EmployeeRecord();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Bundle bundle = getArguments();

        View view = inflater.inflate(R.layout.fragment_employee_record, container, false);

        if (bundle != null) {
            index = bundle.getString("indexno");

            databaseReference = FirebaseDatabase.getInstance().getReference("Employee").child(index).child("Attendance");

            TextView empname = view.findViewById(R.id.emp_name);
            RadioGroup radioGroup = view.findViewById(R.id.radiogroup);
            final RadioButton radioButton1 = view.findViewById(R.id.present_radio);
            final RadioButton radioButton2 = view.findViewById(R.id.absent_radio);
            final RadioButton radioButton3 = view.findViewById(R.id.half_radio);
            final RadioButton radioButton4 = view.findViewById(R.id.full_radio);

            empname.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (radioButton1.isChecked()) {
                        Toast.makeText(getContext(), radioButton1.getText().toString() + " for " + name, Toast.LENGTH_SHORT).show();
                        databaseReference.setValue(radioButton1.getText().toString());
                    }else if (radioButton2.isChecked()){
                        Toast.makeText(getContext(), radioButton2.getText().toString() + " for " + name, Toast.LENGTH_SHORT).show();
                        databaseReference.setValue(radioButton2.getText().toString());
                    }else if (radioButton3.isChecked()){
                        Toast.makeText(getContext(), radioButton3.getText().toString() + " for " + name, Toast.LENGTH_SHORT).show();
                        databaseReference.setValue(radioButton3.getText().toString());
                    }else if (radioButton4.isChecked()){
                        Toast.makeText(getContext(), radioButton4.getText().toString() + " for " + name, Toast.LENGTH_SHORT).show();
                        databaseReference.setValue(radioButton4.getText().toString());
                    } else {
                        Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
                    }

                }
            });

            empname.setText(name);

            Toast.makeText(getContext(), index, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
        }
        return view;
    }
}