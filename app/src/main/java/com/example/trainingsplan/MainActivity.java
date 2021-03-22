package com.example.trainingsplan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Diese Activity oeffnet sich beim Start der App. Zeigt alle potenziellen Module dieser App an.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button trainingsplan = findViewById(R.id.trainingsplan);
        //Noch nicht implementiert
        //Button kalendar = findViewById(R.id.Kalendar);
        //Button wasserkonsum = findViewById(R.id.Wasserkonsum);
        trainingsplan.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.trainingsplan) {
            Intent intent = new Intent(this, TrainingsplanActivity.class);
            startActivity(intent);

        }
    }
}