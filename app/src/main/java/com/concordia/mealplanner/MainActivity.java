package com.concordia.mealplanner;

import android.os.Bundle;
import android.view.MenuItem;

import com.concordia.mealplanner.ui.calendarFragment;
import com.concordia.mealplanner.ui.fridgeFragment;
import com.concordia.mealplanner.ui.groceryFragment;
import com.concordia.mealplanner.ui.savedMealsFragment;
import com.concordia.mealplanner.ui.searchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    private Fragment calendarFrag;
    private Fragment groceryFrag;
    private Fragment savedMealsFrag;
    private Fragment searchFrag;
    private Fragment fridgeFrag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
       // BottomNavigationView navView = findViewById(R.id.nav_view);
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
//                .build();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//        NavigationUI.setupWithNavController(navView, navController);
        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);
        bottomNavigationView.setSelectedItemId(R.id.calendar);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        if (savedInstanceState == null) {
            calendarFrag = new calendarFragment();
            groceryFrag = new groceryFragment();
            savedMealsFrag = new savedMealsFragment();
            searchFrag = new searchFragment();
            fridgeFrag = new fridgeFragment();
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
            switch (item.getItemId()) {
                case R.id.calendar:
                    // check if the fragment is already in container
                    if (calendarFrag.isAdded()) {
                        ft.show(calendarFrag);
                    } else {
                        // fragment needs to be added to frame container
                        ft.add(R.id.fragment_container, calendarFrag, "C");
                    }
                    // Hide fragment
                    if (groceryFrag.isAdded()) { ft.hide(groceryFrag); }
                    // Hide fragment
                    if (savedMealsFrag.isAdded()) { ft.hide(savedMealsFrag); }
                    //Hide fragment
                    if (searchFrag.isAdded()) { ft.hide(searchFrag); }
                    //Hide fragment
                    if (fridgeFrag.isAdded()) { ft.hide(fridgeFrag); }
                    // Commit changes
                    ft.commit();
                    break;
                case R.id.grocery:
                    if (groceryFrag.isAdded()) {
                        ft.show(groceryFrag);
                    }
                    else { ft.add(R.id.fragment_container, groceryFrag, "G"); }
                    if (calendarFrag.isAdded()) { ft.hide(calendarFrag); }
                    if (savedMealsFrag.isAdded()) { ft.hide(savedMealsFrag); }
                    if (searchFrag.isAdded()) { ft.hide(searchFrag); }
                    if (fridgeFrag.isAdded()) { ft.hide(fridgeFrag); }
                    ft.commit();
                    break;
                case R.id.savedMeals:
                    if (savedMealsFrag.isAdded()) {
                        ft.show(savedMealsFrag);
                    }
                    else { ft.add(R.id.fragment_container, savedMealsFrag, "SVM"); }
                    if (calendarFrag.isAdded()) { ft.hide(calendarFrag); }
                    if (groceryFrag.isAdded()) { ft.hide(groceryFrag); }
                    if (searchFrag.isAdded()) { ft.hide(searchFrag); }
                    if (fridgeFrag.isAdded()) { ft.hide(fridgeFrag); }
                    ft.commit();
                    break;
                case R.id.searchMeal:
                    if (searchFrag.isAdded()) {
                        ft.show(searchFrag);
                    }
                    else { ft.add(R.id.fragment_container, searchFrag, "SM"); }
                    if (calendarFrag.isAdded()) { ft.hide(calendarFrag); }
                    if (savedMealsFrag.isAdded()) { ft.hide(savedMealsFrag); }
                    if (groceryFrag.isAdded()) { ft.hide(groceryFrag); }
                    if (fridgeFrag.isAdded()) { ft.hide(fridgeFrag); }
                    ft.commit();
                    break;
                case R.id.fridge:
                    if (fridgeFrag.isAdded()) {
                        ft.show(fridgeFrag);
                    }
                    else { ft.add(R.id.fragment_container, fridgeFrag, "F"); }
                    if (calendarFrag.isAdded()) { ft.hide(calendarFrag); }
                    if (groceryFrag.isAdded()) { ft.hide(groceryFrag); }
                    if (searchFrag.isAdded()) { ft.hide(searchFrag); }
                    if (savedMealsFrag.isAdded()) { ft.hide(savedMealsFrag); }
                    ft.commit();
                    break;
            }//end of switch

            return true;
        }
    };


}