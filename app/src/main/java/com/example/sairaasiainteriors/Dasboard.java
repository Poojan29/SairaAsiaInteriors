package com.example.sairaasiainteriors;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Dasboard extends AppCompatActivity {

    CardView cardView1, cardView2, cardView3, cardView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dasboard);

        cardView1 = findViewById(R.id.dailyrecord);
        cardView2 = findViewById(R.id.attendance);
        cardView3 = findViewById(R.id.work);
        cardView4 = findViewById(R.id.recordcard);

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Dasboard.this, "Coming soon!!!", Toast.LENGTH_SHORT).show();
            }
        });
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Dasboard.this, "Coming soon!!!", Toast.LENGTH_SHORT).show();
            }
        });
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Dasboard.this, "Coming soon!!!", Toast.LENGTH_SHORT).show();
            }
        });
        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Dasboard.this, "Coming soon!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}