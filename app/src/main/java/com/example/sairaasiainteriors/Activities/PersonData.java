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
        recyclerView.setLayoutManager(new LinearLayoutManager(PersonData.this));
        recyclerView.setHasFixedSize(true);
        personDataModelArrayList = new ArrayList<>();

        Bundle bundle = getIntent().getExtras();
        String Current_name = bundle.getString("CurrentUserName", "Current_User_Name");

        setTitle(Current_name);

        databaseReference = FirebaseDatabase.getInstance().getReference("EmployeeRecord").child(Current_name);

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                  String personDataModel = dataSnapshot.getValue(String.class);
                  //personDataModelArrayList.add(personDataModel);
                  Log.d("Array", (personDataModel));
                }
                personDataAdapter = new PersonDataAdapter(PersonData.this, personDataModelArrayList);
                recyclerView.setAdapter(personDataAdapter);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}