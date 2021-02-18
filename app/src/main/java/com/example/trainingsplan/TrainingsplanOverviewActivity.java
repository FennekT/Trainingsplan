package com.example.trainingsplan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class TrainingsplanOverviewActivity extends AppCompatActivity {

    private String titel;
    private String beschreibung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_trainingsplan);
    }
}