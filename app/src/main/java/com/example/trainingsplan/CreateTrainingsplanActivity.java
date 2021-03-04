package com.example.trainingsplan;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CreateTrainingsplanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_trainingsplan);



        Trainingsplan trainingsplan = new Trainingsplan("1", "test", 1,R.drawable.ic_launcher_background);

       /* FloatingActionButton addButton = findViewById(R.id.add_trainingsplan_btn);
        addButton.setOnClickListener(v -> {
//            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//            fragmentTransaction.add(R.id.frameLayout, new CreateTrainingsplanFragment());
//            fragmentTransaction.commit();
            Intent intent = new Intent(this, CreateTrainingsplanActivity.class);
            startActivity(intent);
        });


        */
    }
}
