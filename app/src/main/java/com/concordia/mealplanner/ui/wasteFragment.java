package com.concordia.mealplanner.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.concordia.mealplanner.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link wasteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class wasteFragment extends Fragment {

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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_waste, container, false);
    }
}