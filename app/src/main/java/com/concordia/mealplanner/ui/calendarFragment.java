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
import android.widget.TextView;

import com.concordia.mealplanner.Adapter.calendarAdapter;
import com.concordia.mealplanner.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link calendarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class calendarFragment extends Fragment {
    private String days[];
    private RecyclerView recyclerView;
    private FirebaseAuth mAuth;
    private String currentUser;
    private DatabaseReference referenceSunday;
    private DatabaseReference referenceMonday;
    private DatabaseReference referenceTuesday;
    private DatabaseReference referenceWednesday;
    private DatabaseReference referenceThursday;
    private DatabaseReference referenceFriday;
    private DatabaseReference referenceSaturday;
    boolean sunSet, monSet, turSet, wedSet, thuSet, friSet, satSet;
    //private String[] bSet = new String[7];
    private ArrayList<String> lSet= new ArrayList<String>() ;
    private ArrayList<String> dSet= new ArrayList<String>() ;
    private List <String> b = new ArrayList<>();;
    private String recipe;
    SharedPreferences sp;
    TextView t1, t2,t3;
    Activity context;
    public calendarFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        context = getActivity();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calendar, container, false);
//        recyclerView = view.findViewById(R.id.recyclerViewC);
//        days = getResources().getStringArray(R.array.days_of_the_week);
//
//        calendarAdapter cAdapter = new calendarAdapter(this,days, bSet);
//        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
//        recyclerView.setAdapter(cAdapter);
//        FirebaseUser user = mAuth.getCurrentUser();
//        currentUser = FirebaseAuth.getInstance().getCurrentUser().getUid();
//        referenceSunday = FirebaseDatabase.getInstance().getReference().child("test");//.child("beakfast").child("waffles").child("eggs");//.child("breakfast").child("recipe");
//        referenceMonday = FirebaseDatabase.getInstance().getReference().child("users").child(currentUser).child("Monday");
//        referenceTuesday = FirebaseDatabase.getInstance().getReference().child("users").child(currentUser).child("Tuesday");
//        referenceWednesday = FirebaseDatabase.getInstance().getReference().child("users").child(currentUser).child("Wednesday");
//        referenceThursday = FirebaseDatabase.getInstance().getReference().child("users").child(currentUser).child("Thursday");
//        referenceFriday = FirebaseDatabase.getInstance().getReference().child("users").child(currentUser).child("Friday");
//        referenceSaturday = FirebaseDatabase.getInstance().getReference().child("users").child(currentUser).child("Saturday");
//
//



//                    referenceSunday.addValueEventListener(new ValueEventListener() {
//                        @Override
//                        public void onDataChange(@NonNull DataSnapshot snapshot) {
//                            recipe = snapshot.getValue(String.class);
//                            b.clear();
//                            b.add(recipe);
//
//                        }
//
//                        @Override
//                        public void onCancelled(@NonNull DatabaseError error) {
//
//                        }
//                    });




        // Inflate the layout for this fragment
        return view;
    }//end of onCreateView


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        t1 =(TextView) context.findViewById(R.id.sunB);
        t2 =(TextView) context.findViewById(R.id.tb1);
        t3 =(TextView) context.findViewById(R.id.frib);
        sp = this.getActivity().getSharedPreferences("Res", Context.MODE_PRIVATE);
        String brackF = sp.getString("breakfast","");
        t1.setText(brackF);
        t2.setText(brackF);
        t3.setText(brackF);




    }



} // end of class