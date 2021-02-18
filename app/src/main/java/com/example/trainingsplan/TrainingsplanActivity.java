package com.example.trainingsplan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.trainingsplan.objekte.Trainingsplan;

public class TrainingsplanActivity extends AppCompatActivity implements View.OnClickListener {
    Context context;
    ViewGroup scrollView;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainingsplan);

        Trainingsplan plan = new Trainingsplan("Test11");

        ScrollView scrollView = findViewById(R.id.scrollview);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.layout);
        linearLayout.setOrientation(LinearLayout.VERTICAL);


        // Add Buttons
        //Button button = new Button(this);
        //  button.setText(plan.getName());
        // linearLayout.addView(button);
        ImageButton addButton = findViewById(R.id.addButton);

        // Attach listener to Buttons
        addButton.setOnClickListener(this);
        // Add the LinearLayout element to the ScrollView
//        scrollView.addView(linearLayout);
        context = getApplicationContext();
        // createCardViewProgrammatically();
        // scrollView.addView(linearLayout);
    }

    public void createCardViewProgrammatically() {


        CardView card = new CardView(context);

        // Set the CardView layoutParams
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        card.setLayoutParams(params);

        // Set CardView corner radius
        card.setRadius(9);

        // Set cardView content padding
        card.setContentPadding(15, 15, 15, 15);

        // Set a background color for CardView
        card.setCardBackgroundColor(Color.parseColor("#FFC6D6C3"));

        // Set the CardView maximum elevation
        card.setMaxCardElevation(15);

        // Set CardView elevation
        card.setCardElevation(9);

        // Initialize a new TextView to put in CardView
        TextView tv = new TextView(context);
        tv.setLayoutParams(params);
        tv.setText("CardView\nProgrammatically");
        tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 30);
        tv.setTextColor(Color.RED);

        // Put the TextView in CardView
        card.addView(tv);

        // Finally, add the CardView in root layout
        linearLayout.addView(card);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.addButton) {
            Intent intent = new Intent(this, CreateTrainingsplanFragment.class);
            startActivity(intent);
        }
    }
}