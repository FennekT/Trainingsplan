package com.example.trainingsplan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener, View.OnClickListener {

    private TextToSpeech tts;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tts = new TextToSpeech(this, this);

    }


    @Override
    public void onInit(int status) {
        tts.setLanguage(Locale.JAPANESE);
        Button button = findViewById(R.id.buttonSampleText);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        TextView textView = findViewById(R.id.editTextTextPersonName);
        tts.speak(textView.getText().toString(), TextToSpeech.QUEUE_FLUSH, Bundle.EMPTY, null);
    }
}