package com.example.sairaasiainteriors.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sairaasiainteriors.Models.DailyRecordModel;
import com.example.sairaasiainteriors.Models.PersonDataModel;
import com.example.sairaasiainteriors.R;

import java.util.ArrayList;

public class DailyRecordAdapter extends RecyclerView.Adapter<DailyRecordAdapter.DailyRecordViewHolder> {

    private Context context;
    private ArrayList<DailyRecordModel> arrayList;

    public DailyRecordAdapter(Context context, ArrayList<DailyRecordModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public DailyRecordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.daily_data_single_raw, parent, false);
        return new DailyRecordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DailyRecordViewHolder holder, int position) {
        DailyRecordModel dailyRecordModel = arrayList.get(position);

        String name = dailyRecordModel.getName();
        String work = dailyRecordModel.getWork();
        String attendance = dailyRecordModel.getAttendance();

        holder.name.setText(String.valueOf(name));
        holder.work.setText(String.valueOf(work));
        holder.attendance.setText(String.valueOf(attendance));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class DailyRecordViewHolder extends  RecyclerView.ViewHolder{

        TextView name, work, attendance;

        public DailyRecordViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name1);
            work = itemView.findViewById(R.id.work1);
            attendance = itemView.findViewById(R.id.attendance1);

        }
    }
}
