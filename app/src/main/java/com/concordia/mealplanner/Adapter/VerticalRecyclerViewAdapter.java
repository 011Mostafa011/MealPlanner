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

public class VerticalRecyclerViewAdapter extends RecyclerView.Adapter<VerticalRecyclerViewAdapter.MyViewHolder> {


    Context context;
    String [] dishTitles;
    int[] dishImages;

    public VerticalRecyclerViewAdapter(Context context, String[] favoriteDishes, int[] dishImages)
    {
        this.context = context;
        this.dishTitles = favoriteDishes;
        this.dishImages=dishImages;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //inflate to the search fragment
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vertical,parent,false );
        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.favoriteDishImage.setImageResource(dishImages[(position)]);
        holder.favoriteDishTitle.setText(dishTitles[position]);
    }

    @Override
    public int getItemCount() {
        return dishTitles.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView favoriteDishImage;
        TextView favoriteDishTitle;
       public MyViewHolder(@NonNull View itemView) {
           super(itemView);

           // get the reference of item view's
           favoriteDishImage = (ImageView) itemView.findViewById(R.id.favoriteDishImage);
           favoriteDishTitle = (TextView) itemView.findViewById(R.id.favoriteDishTitle);

       }
   }

}
