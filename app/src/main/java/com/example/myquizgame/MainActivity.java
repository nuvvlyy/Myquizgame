package com.example.myquizgame;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    private Button Btn1;
    private Button Btn2;
    private Button Btn3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       Btn1 = (Button)findViewById(R.id.Btn1);
       Btn2 = (Button)findViewById(R.id.Btn2);
       Btn3 = (Button)findViewById(R.id.Btn3);
       Btn1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this, Main4Activity.class);

               startActivity(intent);
           }
       });

       Btn2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this, visibility.class);

               startActivity(intent);
           }
       });
        Btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, disvisibility.class);

                startActivity(intent);
            }
        });

    }
}