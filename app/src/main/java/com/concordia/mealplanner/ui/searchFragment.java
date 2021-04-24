package com.concordia.mealplanner.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.concordia.mealplanner.Adapter.HorizontalRecyclerViewAdapter;
import com.concordia.mealplanner.Adapter.VerticalRecyclerViewAdapter;
import com.concordia.mealplanner.MainActivity;
import com.concordia.mealplanner.R;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.concordia.mealplanner.SearchActivity;
import com.concordia.mealplanner.chooseWeekdayMealActivity;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomappbar.BottomAppBarTopEdgeTreatment;


public class searchFragment extends Fragment {
    TextView favMealsTextView;
    TextView availableIngTextView;
    ImageView searchBar;
    TextView wafflesEditText;
    ImageView waffleImageView;
    Button confirmWeekdayMealButton;
    Button testButton;

    Activity context;

    SharedPreferences sp;

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
        context = getActivity();

        sp = this.getActivity().getSharedPreferences("Res", Context.MODE_PRIVATE);

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        searchBar = view.findViewById(R.id.searchBar);

        searchBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //showSearchBarDialog();
                //showChooseWeekdayDialog();
                Intent intent = new Intent(context, SearchActivity.class);
                context.startActivity ( intent );
            }
        });



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
        GridLayoutManager gridLayoutManager2 = new GridLayoutManager(view.getContext(),1);
        gridLayoutManager2.setOrientation(GridLayoutManager.HORIZONTAL); // set Horizontal Orientation
        horizontalRecyclerView.setLayoutManager(gridLayoutManager2); // set LayoutManager to RecyclerView

        //assign array items
        fridgeRecipeNames = getResources().getStringArray(R.array.suggested_fridge_dishes);
        HorizontalRecyclerViewAdapter horizontalAdapter = new HorizontalRecyclerViewAdapter(getContext(), fridgeRecipeNames,fridgeDishImages);

        //set adapter
        horizontalRecyclerView.setAdapter(horizontalAdapter);



    return view;



    }

    private void showChooseWeekdayDialog() {
        //inflate layout for this dialog
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_choose_weekday, null);

        final Button confirmButton = (Button) view.findViewById(R.id.confirmButton);

        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //set view to dialog
        builder.setView(view);
        final AlertDialog dialog = builder.create();
        dialog.show();
        /*
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // adds new ingredient here
                confirmWeekdayMealButton = (Button) context.findViewById(R.id.confirmButton);
                confirmWeekdayMealButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        SharedPreferences.Editor editor = sp.edit();
                        editor.putString("breakfast", "waffles");
                        editor.commit();


                    }
                });

                dialog.dismiss();
            }
        });*/
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void showSearchBarDialog() {
        //inflate layout for this dialog
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_search_bar, null);

        final EditText search_bar = view.findViewById(R.id.search_bar);

        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //set view to dialog
        builder.setView(view);
        final AlertDialog dialog = builder.create();
        dialog.show();

        search_bar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // adds new ingredient here
                waffleImageView = (ImageView) context.findViewById(R.id.waffleImageView);
                wafflesEditText = (TextView) context.findViewById(R.id.wafflesEditText);






               /* waffleImageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.setButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                return;
                            }
                        });
                        showChooseWeekdayDialog();

                        Toast toast = Toast.makeText(context, "test", Toast.LENGTH_LONG);
                        toast.show();
                        showChooseWeekdayDialog();
                    }
                });*/

                wafflesEditText.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showChooseWeekdayDialog();
                    }
                });

                testButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast toast = Toast.makeText(context, "test", Toast.LENGTH_LONG);
                        toast.show();

                        dialog.dismiss();

                    }
                });
                showChooseWeekdayDialog();

                dialog.dismiss();
            }
        });
    }
}