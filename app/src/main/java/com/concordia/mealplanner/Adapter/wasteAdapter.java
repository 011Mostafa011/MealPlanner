package com.concordia.mealplanner.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.concordia.mealplanner.R;
import com.concordia.mealplanner.ui.wasteFragment;

public class wasteAdapter extends RecyclerView.Adapter<wasteAdapter.MyViewHolder> {
    String data[];
    wasteFragment context;
    int images[];

    public wasteAdapter(wasteFragment ct , String[] ingredients, int[] Img){
        context = ct;
        data = ingredients;
        images = Img;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.waste_rows, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.ingredientText.setText(data[(position)]);
        holder.ingredientImage.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView ingredientImage;
        TextView ingredientText;
        Button yesButton, noButton;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ingredientImage = itemView.findViewById(R.id.ingredientImageView);
            ingredientText = itemView.findViewById(R.id.ingredientTextView);
        }
    }
}
