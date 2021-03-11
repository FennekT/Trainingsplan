package com.example.trainingsplan;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.GridLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trainingsplan.database.TrainingsplanViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class TrainingsplanActivity extends AppCompatActivity {

    GridLayout gridLayout;
    private TrainingsplanViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainingsplan);

        gridLayout = findViewById(R.id.layout);
        RecyclerView rv = findViewById(R.id.trainingsplanRecyclerView);
        GridLayoutManager llm = new GridLayoutManager(this, 2);
        rv.setLayoutManager(llm);
        //Fuer Testzwecke
        //Trainingsplan trainingsplan = new Trainingsplan("1", "test", 1,R.drawable.ic_launcher_background);
        //TODO: RD Adapter schmiert bei Entity noch ab
        RVAdapter adapter = new RVAdapter();
        rv.setAdapter(adapter);

        ViewModelProvider.AndroidViewModelFactory factory = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());
        vm = new ViewModelProvider(this, factory).get(TrainingsplanViewModel.class);
        vm.getTrainingsplanList().observe(this, adapter::submitList);

        Intent intent = new Intent(this, TrainingsplanCreationActivity.class);
        FloatingActionButton addButton = findViewById(R.id.add_trainingsplan_btn);
        addButton.setOnClickListener(v -> startActivity(intent));
        // createCardViewProgrammatically();
    }

    public void createCardViewProgrammatically() {


        CardView card = new CardView(this);

        // Set the CardView layoutParams


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
        TextView tv = new TextView(this);

        tv.setText("CardView\nProgrammatically");
        tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 30);
        tv.setTextColor(Color.RED);

        // Put the TextView in CardView
        card.addView(tv);

        // Finally, add the CardView in root layout
        gridLayout.addView(tv);


    }
}