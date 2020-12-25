package com.example.sairaasiainteriors.Adapters;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sairaasiainteriors.Activities.Attendance;
import com.example.sairaasiainteriors.Models.AddMemberModel;
import com.example.sairaasiainteriors.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class MyAdapter extends FirebaseRecyclerAdapter<AddMemberModel, MyAdapter.viewholder> {

    public MyAdapter(@NonNull FirebaseRecyclerOptions<AddMemberModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull final viewholder holder, final int position, @NonNull final AddMemberModel model) {
        holder.employeename.setText(model.getFullname());

        if (holder.employeename.getText().toString().isEmpty()){
            holder.employeename.setText("");
        }

        holder.employeename.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = model.getFullname();

                Intent intent = new Intent(view.getContext(), Attendance.class);
                Bundle bundle = new Bundle();
                bundle.putString("Username", holder.employeename.getText().toString());
                intent.putExtras(bundle);
                view.getContext().startActivity(intent);

//                AppCompatActivity appCompatActivity = (AppCompatActivity)view.getContext();
//                appCompatActivitypCompatActivity.getSupportFragmentManager().beginTransaction().replace(R.id.emp_name_layout, myfragment, model.getFullname()).addToBackStack(null).commit();
            }
        });
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.employee_names, parent, false);
        return new viewholder(view);
    }

    public class viewholder extends RecyclerView.ViewHolder{

        TextView employeename;

        public viewholder(@NonNull View itemView) {
            super(itemView);

            employeename = itemView.findViewById(R.id.employeename);

        }

    }

}
