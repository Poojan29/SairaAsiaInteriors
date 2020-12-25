package com.example.sairaasiainteriors.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.sairaasiainteriors.Adapters.RecordAdapter;
import com.example.sairaasiainteriors.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Record extends AppCompatActivity {

    RecyclerView recyclerView;
    ProgressBar progressBar;
    DatabaseReference databaseReference;
    RecordAdapter recordAdapter;
    ArrayList<String> username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        recyclerView = findViewById(R.id.recview_record);
        recyclerView.setLayoutManager(new LinearLayoutManager(Record.this));
        recyclerView.setHasFixedSize(true);

        username = new ArrayList<>();

        databaseReference = FirebaseDatabase.getInstance().getReference("EmployeeRecord");

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    String name = dataSnapshot.getKey();
                    username.add(name);
                }
                recordAdapter = new RecordAdapter(Record.this, username);
                recyclerView.setAdapter(recordAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Record.this, "No data", Toast.LENGTH_SHORT).show();
            }
        });

    }
}