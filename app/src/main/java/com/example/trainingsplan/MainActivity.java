package com.example.trainingsplan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity  {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button trainingsplan =  findViewById(R.id.Trainingsplan);
        Button kalendar = findViewById(R.id.Kalendar);
        Button wasserkonsum = findViewById(R.id.Wasserkonsum);
    }

}