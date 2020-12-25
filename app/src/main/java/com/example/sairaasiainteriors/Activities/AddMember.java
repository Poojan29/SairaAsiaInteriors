package com.example.sairaasiainteriors.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.sairaasiainteriors.Models.AddMemberModel;
import com.example.sairaasiainteriors.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddMember extends AppCompatActivity {

    TextInputEditText full_name, user_name, email;
    Button add_member;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_member);

        full_name = findViewById(R.id.fullname);
        user_name = findViewById(R.id.username);
        email = findViewById(R.id.email);
        add_member = findViewById(R.id.addbutton);

        databaseReference = FirebaseDatabase.getInstance().getReference("Employee");

        add_member.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullname = full_name.getText().toString().trim();
                String username = user_name.getText().toString().trim();
                String emailid = email.getText().toString().trim();

                if (fullname.isEmpty()){
                    Toast.makeText(AddMember.this, "Please enter your FullName.", Toast.LENGTH_SHORT).show();
                }else if (username.isEmpty()){
                    Toast.makeText(AddMember.this, "Please enter your FullName.", Toast.LENGTH_SHORT).show();
                }else if (emailid.isEmpty()){
                    Toast.makeText(AddMember.this, "Please enter your FullName.", Toast.LENGTH_SHORT).show();
                }else{
                    AddMemberModel addMemberModel = new AddMemberModel(fullname, username, emailid);
                    databaseReference.child(fullname).setValue(addMemberModel);
                    Toast.makeText(AddMember.this, "Member Added Successful.", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), EmployeeList.class));
                    finish();
                }
            }
        });

    }
}