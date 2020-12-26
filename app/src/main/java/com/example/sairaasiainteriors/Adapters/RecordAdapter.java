package com.example.sairaasiainteriors.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sairaasiainteriors.Activities.PersonData;
import com.example.sairaasiainteriors.R;

import java.util.ArrayList;

public class RecordAdapter extends RecyclerView.Adapter<RecordAdapter.RecordViewHolder> {

    private Context context;
    private ArrayList<String> username;

    public RecordAdapter(Context context, ArrayList<String> username) {
        this.context = context;
        this.username = username;
    }

    @NonNull
    @Override
    public RecordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.employee_names, parent, false);
        return new RecordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecordViewHolder holder, int position) {

        final String name =username.get(position);

        holder.name.setText(name);

        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PersonData.class);
                Bundle bundle = new Bundle();
                bundle.putString("CurrentUserName", name);
                intent.putExtras(bundle);
                view.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return username.size();
    }

    public class RecordViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        ImageView imageView;

        public RecordViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.employeename);
            imageView = itemView.findViewById(R.id.demo_person);

        }
    }
}
