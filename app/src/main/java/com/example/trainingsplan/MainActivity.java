package com.example.trainingsplan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button trainingsplan = findViewById(R.id.Trainingsplan);
        //Noch nicht implementiert
        //Button kalendar = findViewById(R.id.Kalendar);
        //Button wasserkonsum = findViewById(R.id.Wasserkonsum);
        trainingsplan.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.Trainingsplan) {
            Intent intent = new Intent(this, TrainingsplanActivity.class);
            startActivity(intent);
        }
    }
}