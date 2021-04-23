package com.concordia.mealplanner.ui;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.concordia.mealplanner.Adapter.wasteAdapter;
import com.concordia.mealplanner.R;

public class wasteFragment extends Fragment {
    private String ingredients[];
    private RecyclerView recyclerView;
    int images[] = {R.drawable.flour, R.drawable.salt_img, R.drawable.baking_powder, R.drawable.chicken, R.drawable.fries, R.drawable.pasta_img, R.drawable.parmesan_cheese, R.drawable.tomato_sauce, R.drawable.beef};
    Button test;
    Activity context;
    SharedPreferences sp;

    public wasteFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_waste, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewWaste);
        ingredients = getResources().getStringArray(R.array.ingredients_in_fridge);
        wasteAdapter wAdapter = new wasteAdapter(this, ingredients, images);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(wAdapter);

        sp = this.getActivity().getSharedPreferences("Res", Context.MODE_PRIVATE);

        // Inflate the layout for this fragment
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        test = (Button)  context.findViewById(R.id.confirmButton);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor = sp.edit();
                editor.putString("breakfast", "Waffles");
                editor.commit();


            }
        });


    }
}