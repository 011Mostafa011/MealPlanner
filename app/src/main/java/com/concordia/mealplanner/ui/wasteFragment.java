package com.concordia.mealplanner.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.concordia.mealplanner.Adapter.wasteAdapter;
import com.concordia.mealplanner.R;

public class wasteFragment extends Fragment {
    private String ingredients[];
    private RecyclerView recyclerView;
    int images[] = {R.drawable.chicken, R.drawable.fries};

    public wasteFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_waste, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewGrocery);
        ingredients = getResources().getStringArray(R.array.ingredients_of_the_week);
        wasteAdapter wAdapter = new wasteAdapter(this, ingredients, images);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(wAdapter);

        // Inflate the layout for this fragment
        return view;
    }
}