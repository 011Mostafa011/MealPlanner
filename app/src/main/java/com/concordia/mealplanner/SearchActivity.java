package com.concordia.mealplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {
    TextView wafflesEditText;
    ImageView waffleImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        waffleImageView = (ImageView) findViewById(R.id.waffleImageView);
        wafflesEditText = (TextView) findViewById(R.id.wafflesEditText);



        wafflesEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SearchActivity.this, selectedActivity.class));
            }
        });

         waffleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(SearchActivity.this, selectedActivity.class));

            }
        });

    } //end on create
}