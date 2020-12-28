package com.example.sairaasiainteriors.Activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.sairaasiainteriors.Adapters.PersonDataAdapter;
import com.example.sairaasiainteriors.Models.PersonDataModel;
import com.example.sairaasiainteriors.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class PersonData extends AppCompatActivity {

    RecyclerView recyclerView;
    PersonDataAdapter personDataAdapter;
    DatabaseReference databaseReference;
    ArrayList<PersonDataModel> personDataModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_data);

        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        personDataModelArrayList = new ArrayList<>();

        Bundle bundle = getIntent().getExtras();
        String Current_name = bundle.getString("CurrentUserName", "Current_User_Name");

        setTitle(Current_name);

        databaseReference = FirebaseDatabase.getInstance().getReference("EmployeeRecord").child(Current_name);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                        String date = dataSnapshot.child("date").getValue(String.class);
                        String work = dataSnapshot.child("work").getValue(String.class);
                        String attendance = dataSnapshot.child("attendance").getValue(String.class);

                        PersonDataModel model = new PersonDataModel(attendance, date, work);
                        personDataModelArrayList.add(model);
                        Log.d("Poojan", String.valueOf(personDataModelArrayList));
                    }
                    personDataAdapter = new PersonDataAdapter(PersonData.this, personDataModelArrayList);
                    recyclerView.setAdapter(personDataAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}