package com.example.trainingsplan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.example.trainingsplan.objekte.Trainingsplan;

public class TrainingsplanActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainingsplan);
        ScrollView scrollView = findViewById(R.id.scroll);

        Trainingsplan plan = new Trainingsplan("Test11");

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        // Add Buttons
        Button button = new Button(this);
        button.setText(plan.getName());
        linearLayout.addView(button);
        ImageButton addButton = findViewById(R.id.addButton);

        // Attach listener to Buttons
        addButton.setOnClickListener(this);
        // Add the LinearLayout element to the ScrollView
//        scrollView.addView(linearLayout);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.addButton) {
            Intent intent = new Intent(this, CreateTrainingsplanActivity.class);
            startActivity(intent);
        }
    }
}