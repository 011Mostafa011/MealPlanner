package com.concordia.mealplanner.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.concordia.mealplanner.R;


public class HorizontalRecyclerViewAdapter extends RecyclerView.Adapter<HorizontalRecyclerViewAdapter.MyViewHolder>{


    String[] recipeNames;
    int[] fridgeDishImages;

    Context context;

    public HorizontalRecyclerViewAdapter(Context context, String [] recipeNames, int [] fridgeDishImages) {
        this.context = context;
        this.recipeNames = recipeNames;
        this.fridgeDishImages=fridgeDishImages;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // inflate the item Layout item_horizontal
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_horizontal, parent, false);

        // set the view's size, margins, paddings and layout parameters
         MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // set the dish names in text items
        holder.DishTitle.setText(recipeNames[position]);
        // set dish images in image items
        holder.DishImage.setImageResource(fridgeDishImages[position]);
    }


    @Override
    public int getItemCount() {
        return recipeNames.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView DishImage;
        TextView DishTitle;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            DishImage = (ImageView) itemView.findViewById(R.id.fridgeDishImageView);
            DishTitle = (TextView) itemView.findViewById(R.id.fridgeDishTitleView);


        }
    }
}
