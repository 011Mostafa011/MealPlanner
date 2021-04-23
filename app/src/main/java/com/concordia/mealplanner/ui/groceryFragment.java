package com.concordia.mealplanner.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.concordia.mealplanner.Adapter.groceryAdapter;
import com.concordia.mealplanner.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class groceryFragment extends Fragment {

    Activity context;

    Button plusButton;

    FirebaseAuth auth = FirebaseAuth.getInstance();
    FirebaseUser appUser = auth.getCurrentUser();

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
        View view = inflater.inflate(R.layout.fragment_grocery, container, false);

        context = getActivity();

        recyclerView = view.findViewById(R.id.recyclerViewGrocery);
        ingredients = getResources().getStringArray(R.array.ingredients_of_the_week);
        quantity = getResources().getStringArray(R.array.ingredient_quantity);
        groceryAdapter gAdapter = new groceryAdapter(this, ingredients, quantity);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(gAdapter);

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        plusButton = (Button) context.findViewById(R.id.plusButton);
    }

    public void onStart() {
        super.onStart();

        if (appUser != null) {
            plusButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showAddIngredientDialog();
                }
            });
        } else {
            Log.d(TAG, "no user registered");
            // No user is signed in
        }
    }

    private void showAddIngredientDialog() {
        //inflate layout for this dialog
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_add_ingredient, null);

        final EditText ingredient = view.findViewById(R.id.ingredientEditText);
        final EditText ingredientQuantity = view.findViewById(R.id.quantityEditText);
        final Button addIngredient = view.findViewById(R.id.addIngredientButton);
        final Button cancel = view.findViewById(R.id.cancelButton);


        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //set view to dialog
        builder.setView(view);
        final AlertDialog dialog = builder.create();
        dialog.show();

        addIngredient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // adds new ingredient here

                dialog.dismiss();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }
} // end of class