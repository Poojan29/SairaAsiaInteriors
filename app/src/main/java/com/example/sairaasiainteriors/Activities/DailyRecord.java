package com.example.sairaasiainteriors.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.sairaasiainteriors.Adapters.DailyRecordAdapter;
import com.example.sairaasiainteriors.Models.DailyRecordModel;
import com.example.sairaasiainteriors.Models.PersonDataModel;
import com.example.sairaasiainteriors.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DailyRecord extends AppCompatActivity {

    RecyclerView recyclerView;
    DailyRecordAdapter dailyRecordAdapter;
    ArrayList<DailyRecordModel> dailyRecordModels;
    DatabaseReference databaseReference;
    String currentDateandTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_record);

        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        dailyRecordModels = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        currentDateandTime = sdf.format(new Date());

        databaseReference = FirebaseDatabase.getInstance().getReference("EmployeeRecord");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                        String name = dataSnapshot.child(currentDateandTime).child("name").getValue(String.class);
                        String work = dataSnapshot.child(currentDateandTime).child("work").getValue(String.class);
                        String attendance = dataSnapshot.child(currentDateandTime).child("attendance").getValue(String.class);

                        Log.d("Data1", name);

                        DailyRecordModel dailyRecordModel = new DailyRecordModel(name, work, attendance);
                        dailyRecordModels.add(dailyRecordModel);

                        Log.d("Data2", dailyRecordModel.getAttendance());
                    }

                    dailyRecordAdapter = new DailyRecordAdapter(DailyRecord.this, dailyRecordModels);
                    recyclerView.setAdapter(dailyRecordAdapter);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}