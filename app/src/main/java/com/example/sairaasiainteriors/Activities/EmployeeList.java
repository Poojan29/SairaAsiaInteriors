package com.example.sairaasiainteriors.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.sairaasiainteriors.Models.AddMemberModel;
import com.example.sairaasiainteriors.Adapters.MyAdapter;
import com.example.sairaasiainteriors.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;

public class EmployeeList extends AppCompatActivity {

    MyAdapter adapter;
    RecyclerView recyclerView;
    FloatingActionButton floatingActionButton;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_list);

        floatingActionButton = findViewById(R.id.memberadd_btn);
        progressBar = findViewById(R.id.progressbar);
        recyclerView = findViewById(R.id.recview_empname);
        recyclerView.setLayoutManager(new LinearLayoutManager(EmployeeList.this));
        recyclerView.setHasFixedSize(true);
        progressBar.setVisibility(View.VISIBLE);
        FirebaseRecyclerOptions<AddMemberModel> options =
                new FirebaseRecyclerOptions.Builder<AddMemberModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference("Employee"), AddMemberModel.class)
                        .build();

        adapter = new MyAdapter(options);
        recyclerView.setAdapter(adapter);
        progressBar.setVisibility(View.GONE);


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), AddMember.class));
                finish();
            }
        });

    }
    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}