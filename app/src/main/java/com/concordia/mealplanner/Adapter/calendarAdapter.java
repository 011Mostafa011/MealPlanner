package com.concordia.mealplanner.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.concordia.mealplanner.R;
import com.concordia.mealplanner.ui.calendarFragment;

public class calendarAdapter extends RecyclerView.Adapter<calendarAdapter.MyViewHolder> {
    String data[];
    calendarFragment context;

    public calendarAdapter(calendarFragment ct , String[] days){
        context = ct;
        data = days;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.calendar_rows, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
       holder.daysText.setText(data[(position)]);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView daysText, breakfast, lunch, dinner;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            daysText = itemView.findViewById(R.id.daysTextView);
            breakfast = itemView.findViewById(R.id.btextView);
            lunch = itemView.findViewById(R.id.ltextView);
            dinner = itemView.findViewById(R.id.dtextView);
        }
    }
}
