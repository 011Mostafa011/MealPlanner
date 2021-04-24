package com.concordia.mealplanner.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.concordia.mealplanner.Adapter.groceryListAdapter;
import com.concordia.mealplanner.R;
import com.concordia.mealplanner.localVariables.Ingredients;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link groceryFragment#} factory method to
 * create an instance of this fragment.
 */
public class groceryFragment extends Fragment {

    private ArrayList<Ingredients> groceryList;
    private String ingredients[];
    private RecyclerView recyclerView;

    private String[] quantity;

    String TAG = "groceryFragment";


    public groceryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_grocery, container, false);

        recyclerView = view.findViewById(R.id.recyclerGroceryView);
        ingredients = getResources().getStringArray(R.array.ingredients_of_the_week);

        quantity = getResources().getStringArray(R.array.ingredient_quantity);
        groceryAdapter gAdapter = new groceryAdapter(this, ingredients, quantity);

        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(gAdapter);

        // Inflate the layout for this fragment
        return view;

    }
}