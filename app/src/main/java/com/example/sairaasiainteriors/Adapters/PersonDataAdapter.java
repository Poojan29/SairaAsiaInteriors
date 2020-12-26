package com.example.sairaasiainteriors.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sairaasiainteriors.Models.PersonDataModel;
import com.example.sairaasiainteriors.R;

import java.util.ArrayList;

public class PersonDataAdapter extends RecyclerView.Adapter<PersonDataAdapter.PersonDataViewHolder> {

    private Context context;
    private ArrayList<PersonDataModel> arrayList;

    public PersonDataAdapter(Context context, ArrayList<PersonDataModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public PersonDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_data_single_raw, parent, false);
        return new PersonDataViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonDataViewHolder holder, int position) {
        PersonDataModel personDataModel = arrayList.get(position);

//        holder.date.setText(personDataModel.getDate());
        holder.work.setText(personDataModel.getName());
        holder.attendance.setText(personDataModel.getAttendance());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class PersonDataViewHolder extends RecyclerView.ViewHolder{

        TextView date, work, attendance;

        public PersonDataViewHolder(@NonNull View itemView) {
            super(itemView);

            date = itemView.findViewById(R.id.date);
            work = itemView.findViewById(R.id.work);
            attendance = itemView.findViewById(R.id.attendance);


        }
    }
}
