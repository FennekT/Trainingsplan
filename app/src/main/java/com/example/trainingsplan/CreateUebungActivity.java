package com.example.trainingsplan;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class CreateUebungActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_uebung);



        Trainingsplan trainingsplan = new Trainingsplan("1", "test", 1,R.drawable.ic_launcher_background);


    }
}
