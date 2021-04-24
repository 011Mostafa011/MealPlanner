package com.concordia.mealplanner.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.concordia.mealplanner.R;
import com.concordia.mealplanner.localVariables.Ingredients;
import com.concordia.mealplanner.ui.groceryFragment;

import java.util.ArrayList;

public class groceryListAdapter extends RecyclerView.Adapter<groceryListAdapter.MyViewHolder> {
   private String groceryList[];
   private groceryFragment context;
   private int images[];

//   private ArrayList <Ingredients> groceryList;

    public groceryListAdapter(groceryFragment ct , String data[], int[] Img){

        this.context = ct;
        this.groceryList = data;
        this.images = Img;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.groceryitem_row, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.ingredientText.setText(groceryList[(position)]);
        holder.ingredientImage.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return groceryList.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView ingredientImage;
        TextView ingredientText;
        CheckBox groceryCheckbox;
        Number quantity;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ingredientImage = itemView.findViewById(R.id.ingredientImageView2);
            ingredientText = itemView.findViewById(R.id.ingGroceryText);
            groceryCheckbox = itemView.findViewById(R.id.groceryCheck);

        }
    }
}
