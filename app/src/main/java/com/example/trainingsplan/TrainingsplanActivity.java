package com.example.trainingsplan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.example.trainingsplan.objekte.Trainingsplan;

public class TrainingsplanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainingsplan);
        ScrollView scrollView = findViewById(R.id.scroll);
        Trainingsplan plan = new Trainingsplan("Test1");

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

// Add Buttons
        Button button = new Button(this);
        button.setText(plan.getName());
        linearLayout.addView(button);

// Add the LinearLayout element to the ScrollView
        scrollView.addView(linearLayout);
    }
}