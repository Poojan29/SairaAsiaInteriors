package com.example.sairaasiainteriors.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sairaasiainteriors.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    TextView forgot,nsignup;
    TextInputEditText nemail,npass;
    Button nlogin;
    FirebaseAuth mAuth;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nemail = findViewById(R.id.email_login);
        npass  = findViewById(R.id.password_login);
        nlogin = findViewById(R.id.loginbutton);
        nsignup = findViewById(R.id.registertxt);
        forgot = findViewById(R.id.ftpassword);
        mAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.login_progessbar);

        if (mAuth.getCurrentUser() != null){
            progressBar.setVisibility(View.VISIBLE);
            Toast.makeText(this, "Already Logged in", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(), Dasboard.class));
            progressBar.setVisibility(View.GONE);
            finish();
        }else{

        }// it is check that current user previously logged in or not


        nlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = nemail.getText().toString().trim();
                String pass = npass.getText().toString().trim();
                if (email.isEmpty()) {
                    Toast.makeText(Login.this, "Please enter your Email.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (pass.length() <= 6) {
                    Toast.makeText(Login.this, "Please enter your Password.", Toast.LENGTH_SHORT).show();

                } else {
                    progressBar.setVisibility(View.VISIBLE);
                    mAuth.signInWithEmailAndPassword(email, pass)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(Login.this, "Login Successful.", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(getApplicationContext(), Dasboard.class));
                                        progressBar.setVisibility(View.GONE);
                                        finish();

                                    } else {
                                        Toast.makeText(Login.this, "Invalid Password or E-mail", Toast.LENGTH_SHORT).show();
                                        progressBar.setVisibility(View.GONE);
                                        forgot.setVisibility(View.VISIBLE);
                                    }
                                }
                            });
                }
            }
        });

        nsignup.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(), Register.class));
                    }
                });

        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Login.this, "Coming soon!!!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}


