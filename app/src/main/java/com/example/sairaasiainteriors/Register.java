package com.example.sairaasiainteriors;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {

    ProgressBar progressBar;
    EditText username,emailid,password;
    Button regbtn;
    FirebaseAuth mAuth;
    TextView loginaccount;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
    String userID;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);

        loginaccount = findViewById(R.id.logintxt);
        username = findViewById(R.id.username_register);
        emailid = findViewById(R.id.email_register);
        password = findViewById(R.id.password_register);
        regbtn = findViewById(R.id.regbutton);
        mAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.reg_progressbar);

        databaseReference = FirebaseDatabase.getInstance().getReference("Employees");
        mAuth = FirebaseAuth.getInstance();


        loginaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Login.class));
            }
        });

        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String email = emailid.getText().toString().trim();
                final String pass = password.getText().toString().trim();
                final String users = username.getText().toString();

                if (users.isEmpty()){
                    Toast.makeText(Register.this, "Please enter your Username.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (email.isEmpty()){
                    Toast.makeText(Register.this, "Please enter your Email.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (pass.length()<=6){
                    Toast.makeText(Register.this, "Your password must be contain 6 characters.", Toast.LENGTH_SHORT).show();
                }else {
                    progressBar.setVisibility(View.VISIBLE);
                    mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {

                                Employee information = new Employee(users, email);

                                FirebaseDatabase.getInstance().getReference("Employees")
                                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                        .setValue(information).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        Toast.makeText(Register.this, "Registration complete.", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(getApplicationContext(), Dasboard.class));
                                    }
                                });
                            } else {
                                Toast.makeText(Register.this, "Error!", Toast.LENGTH_SHORT).show();
                                progressBar.setVisibility(View.GONE);
                            }
                        }
                    });
                }
            }
        });
    }
}