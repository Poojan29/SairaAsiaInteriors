package com.example.sairaasiainteriors;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class MyAdapter extends FirebaseRecyclerAdapter<EmployeeNames, MyAdapter.viewholder> {



    public MyAdapter(@NonNull FirebaseRecyclerOptions<EmployeeNames> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull viewholder holder, int position, @NonNull EmployeeNames model) {
        holder.employeename.setText(model.getName());
        holder.indexno.setText(model.getIndexno());
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.employee_names, parent, false);
        return new viewholder(view);
    }

    public class viewholder extends RecyclerView.ViewHolder{

        TextView employeename, indexno;

        public viewholder(@NonNull View itemView) {
            super(itemView);

            employeename = itemView.findViewById(R.id.employeename);
            indexno = itemView.findViewById(R.id.indexno);

        }
    }

}
