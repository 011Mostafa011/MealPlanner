package com.concordia.mealplanner.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.concordia.mealplanner.Adapter.HorizontalRecyclerViewAdapter;
import com.concordia.mealplanner.Adapter.VerticalRecyclerViewAdapter;
import com.concordia.mealplanner.R;


public class searchFragment extends Fragment {



    //vertical view

    private String favoriteDishTitles[];
    int favoriteDishImages[] = {R.drawable.taco_salad,R.drawable.butter_chicken, R.drawable.paella, R.drawable.asian_garlic_noodle};

    //horizontal view
    private String[] fridgeRecipeNames;
    int fridgeDishImages[] = {R.drawable.ham_burger, R.drawable.escalope, R.drawable.the_spaghetti_bolognese};

    private RecyclerView verticalRecyclerView;
    private RecyclerView horizontalRecyclerView;



    public searchFragment() {
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
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        //vertical recycler view
        verticalRecyclerView = view.findViewById(R.id.recyclerview1);
        // set a GridLayoutManager with default vertical orientation and 3 number of columns
        GridLayoutManager gridLayoutManager = new GridLayoutManager(view.getContext(),2);
        verticalRecyclerView.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView

        //assign array items
        favoriteDishTitles= getResources().getStringArray(R.array.favorite_dishes);
        VerticalRecyclerViewAdapter verticalAdapter = new VerticalRecyclerViewAdapter(getContext(), favoriteDishTitles,favoriteDishImages);

        //set adapter
        verticalRecyclerView.setAdapter(verticalAdapter);

        //--------------------------------------//


        //horizontal recycler view


        //get reference
        horizontalRecyclerView = view.findViewById(R.id.recyclerview2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL); // set Horizontal Orientation
        horizontalRecyclerView.setLayoutManager(linearLayoutManager); // set LayoutManager to RecyclerView

        //assign array items
        fridgeRecipeNames = getResources().getStringArray(R.array.suggested_fridge_dishes);
        HorizontalRecyclerViewAdapter horizontalAdapter = new HorizontalRecyclerViewAdapter(getContext(), fridgeRecipeNames,fridgeDishImages);

        //set adapter
        horizontalRecyclerView.setAdapter(horizontalAdapter);



    return view;



    }
}