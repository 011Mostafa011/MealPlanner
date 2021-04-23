package com.concordia.mealplanner;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;

import com.concordia.mealplanner.ui.calendarFragment;
import com.concordia.mealplanner.ui.groceryFragment;
import com.concordia.mealplanner.ui.searchFragment;
import com.concordia.mealplanner.ui.wasteFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    private Fragment calendarFrag;
    private Fragment groceryFrag;
    private Fragment searchFrag;
    private Fragment wasteFrag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);
        bottomNavigationView.setSelectedItemId(R.id.calendar);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        if (savedInstanceState == null) {
            calendarFrag = new calendarFragment();
            groceryFrag = new groceryFragment();
            searchFrag = new searchFragment();
            wasteFrag = new wasteFragment();
        }

        ft.add(R.id.fragment_container, calendarFrag, "C");
        ft.commit();


    } //end of on create



    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

            //show the selected item in the nav bar
//            switch (item.getItemId()) {
//                case R.id.calendar:
//                    // check if the fragment is already in container
//                    if (calendarFrag.isAdded()) {
//                        ft.show(calendarFrag);
//                    } else {
//                        // fragment needs to be added to frame container
//                        ft.add(R.id.fragment_container, calendarFrag, "C");
//                    }
//                    // Hide fragment
//                    if (groceryFrag.isAdded()) { ft.hide(groceryFrag); }
//                    //Hide fragment
//                    if (searchFrag.isAdded()) { ft.hide(searchFrag); }
//                    //Hide fragment
//                    if (wasteFrag.isAdded()) { ft.hide(wasteFrag); }
//                    // Commit changes
//                    ft.commit();
//                    break;
//                case R.id.grocery:
//                    if (groceryFrag.isAdded()) {
//                        ft.show(groceryFrag);
//                    }
//                    else { ft.add(R.id.fragment_container, groceryFrag, "G"); }
//                    if (calendarFrag.isAdded()) { ft.hide(calendarFrag); }
//                    if (searchFrag.isAdded()) { ft.hide(searchFrag); }
//                    if (wasteFrag.isAdded()) { ft.hide(wasteFrag); }
//                    ft.commit();
//                    break;
//                case R.id.searchMeal:
//                    if (searchFrag.isAdded()) {
//                        ft.show(searchFrag);
//                    }
//                    else { ft.add(R.id.fragment_container, searchFrag, "SM"); }
//                    if (calendarFrag.isAdded()) { ft.hide(calendarFrag); }
//                    if (groceryFrag.isAdded()) { ft.hide(groceryFrag); }
//                    if (wasteFrag.isAdded()) { ft.hide(wasteFrag); }
//                    ft.commit();
//                    break;
//                case R.id.waste:
//                    if (wasteFrag.isAdded()) {
//                        ft.show(wasteFrag);
//                    }
//                    else { ft.add(R.id.fragment_container, wasteFrag, "F"); }
//                    if (calendarFrag.isAdded()) { ft.hide(calendarFrag); }
//                    if (groceryFrag.isAdded()) { ft.hide(groceryFrag); }
//                    if (searchFrag.isAdded()) { ft.hide(searchFrag); }
//                    ft.commit();
//                    break;
//            }//end of switch
            switch (item.getItemId()) {
                case R.id.calendar:
                    selectedFragment = new calendarFragment();
                    break;

                case R.id.searchMeal:
                    selectedFragment = new searchFragment();
                    break;

                case R.id.grocery:
                    selectedFragment = new groceryFragment();
                    break;

                case R.id.waste:
                    selectedFragment = new wasteFragment();;
                    break;


            }

            if(selectedFragment != null) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).addToBackStack(null).commit();
            }

            return true;
        }
    };


}