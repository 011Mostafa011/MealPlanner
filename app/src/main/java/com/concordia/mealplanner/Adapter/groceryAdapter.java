package com.concordia.mealplanner.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.concordia.mealplanner.R;
import com.concordia.mealplanner.ui.groceryFragment;

public class groceryAdapter extends RecyclerView.Adapter<groceryAdapter.MyViewHolder> {
    String data[];
    String quantity[];
    groceryFragment context;

    public groceryAdapter(groceryFragment ct, String[] ingredients, String[] ingQuantity){
        context = ct;
        data = ingredients;
        quantity = ingQuantity;
    }


    @NonNull
    @Override
    public groceryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.grocery_rows, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.ingredientText.setText(data[(position)]);
        holder.quantityText.setText(quantity[(position)]);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView ingredientText;
        TextView quantityText;
        CheckBox checkBox;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ingredientText = itemView.findViewById(R.id.ingredientTextView);
            quantityText = itemView.findViewById(R.id.quantityTextView);
        }
    }
}
