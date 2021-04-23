package com.concordia.mealplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class selectedActivity extends AppCompatActivity {
    Button confirmWeekdayMealButton;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected);

        sp = this.getSharedPreferences("Res", Context.MODE_PRIVATE);

        confirmWeekdayMealButton = (Button) findViewById(R.id.confirmWeekdayMealButton);

        confirmWeekdayMealButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor = sp.edit();
                editor.putString("breakfast", "Waffles");
                editor.commit();

                startActivity(new Intent(selectedActivity.this, MainActivity.class));
            }
        });

    }
}