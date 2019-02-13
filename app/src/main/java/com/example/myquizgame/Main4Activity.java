package com.example.myquizgame;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Random;

public class Main4Activity extends AppCompatActivity   {
    private TextView countLabel;
    private TextView questionLabel;
    private Button answerBtn1;
    private Button answerBtn2;
    private Button answerBtn3;
    private Button answerBtn4;
    private TextToSpeech Text;
    private GestureDetectorCompat gestureDetectorCompat = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Text = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = Text.setLanguage(Locale.ENGLISH);

                    if (result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "Language not supported");
                    } else {
                        answerBtn1.setEnabled(true);
                    }
                } else {
                    Log.e("TTS", "Initialization failed");
                }
            }
        });

        Text.setPitch(1);
        Text.setSpeechRate((float) 0.5);

        //CountDownTimer
        new CountDownTimer(1000, 1000) {

            public void onTick(long millisUntilFinished) {

            }
            public void onFinish() {
                Text.speak("This is an introduction to use. Swipe to the left to skip the introduction."
                , TextToSpeech.QUEUE_ADD, null);

            }
        }.start();

        new CountDownTimer(10000, 1000) {

            public void onTick(long millisUntilFinished) {

            }
            public void onFinish() {
                Text.speak(
                        "Top of the screen has current numbering of a question!" +
                        "Below of current numbering have a current question!" +
                        "The center of the screen has a choice button! " +
                        "If you want to exit from an introduction. please, click back to skip the introduction.", TextToSpeech.QUEUE_ADD, null);

            }
        }.start();


//
//        Text.speak("This is an introduction to use. Swipe to the left to skip the introduction.", TextToSpeech.QUEUE_FLUSH, null);
//        Text.speak("top of the screen has current numbering of a question.", TextToSpeech.QUEUE_FLUSH, null);
//        Text.speak("Below of current numbering have a current question.", TextToSpeech.QUEUE_FLUSH, null);
//        Text.speak("and the center of the screen has a choice button. You can long-click a button to listening to a choice", TextToSpeech.QUEUE_FLUSH, null);
//        Text.speak("if you want to exit from an introduction. please, Swipe to the left to skip the introduction.", TextToSpeech.QUEUE_FLUSH, null);
//        Text.speak("when you click a button is mean you select this for an answer", TextToSpeech.QUEUE_FLUSH, null);
//        Text.speak("if this is the right answer we say correct!", TextToSpeech.QUEUE_FLUSH, null);
//        Text.speak("if this is the incorrect answer we say incorrect and a correct answer", TextToSpeech.QUEUE_FLUSH, null);
//        Text.speak("if you want to exit from an introduction. please, Swipe to the left to skip the introduction.", TextToSpeech.QUEUE_FLUSH, null);

        countLabel = (TextView) findViewById(R.id.countLabel);
        questionLabel = (TextView) findViewById(R.id.questionLabel);
        answerBtn1 = (Button) findViewById(R.id.TanswerBtn1);
        answerBtn2 = (Button) findViewById(R.id.TanswerBtn2);
        answerBtn3 = (Button) findViewById(R.id.TanswerBtn3);
        answerBtn4 = (Button) findViewById(R.id.TanswerBtn4);

        answerBtn1.setBackgroundColor(Color.rgb(222, 222, 222));
        answerBtn2.setBackgroundColor(Color.rgb(222, 222, 222));
        answerBtn3.setBackgroundColor(Color.rgb(222, 222, 222));
        answerBtn4.setBackgroundColor(Color.rgb(222, 222, 222));

        questionLabel.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                String text = questionLabel.getText().toString();
                //Text.speak(text, TextToSpeech.QUEUE_FLUSH, null);
                               return true;
            }
        });
        answerBtn1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                String text = answerBtn1.getText().toString();
                Text.speak(text, TextToSpeech.QUEUE_FLUSH, null);
                Text.speak("when you click a button is mean you select this for an answer" +
                        "If this is the right answer we say correct!" +
                        "If this is the incorrect answer we say incorrect and a correct answer!"+
                        "If you want to exit from an introduction. please, click back to exit the introduction.", TextToSpeech.QUEUE_FLUSH, null);

                return true;
            }
        });
        answerBtn2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                String text = answerBtn2.getText().toString();
                Text.speak(text, TextToSpeech.QUEUE_FLUSH, null);
                Text.speak("when you click a button is mean you select this for an answer" +
                        "If this is the right answer we say correct!" +
                        "If this is the incorrect answer we say incorrect and a correct answer" +
                        "If you want to exit from an introduction. please, click back to exit the introduction.", TextToSpeech.QUEUE_FLUSH, null);

                return true;
            }
        });
        answerBtn3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                String text = answerBtn3.getText().toString();
                Text.speak(text, TextToSpeech.QUEUE_FLUSH, null);
                Text.speak("when you click a button is mean you select this for an answer" +
                        "If this is the right answer we say correct!" +
                        "If this is the incorrect answer we say incorrect and a correct answer!"
                        +"If you want to exit from an introduction. please, click back to exit the introduction.", TextToSpeech.QUEUE_FLUSH, null);

                return true;
            }
        });
        answerBtn4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                String text = answerBtn3.getText().toString();
                Text.speak(text, TextToSpeech.QUEUE_FLUSH, null);
                Text.speak("when you click a button is mean you select this for an answer" +
                        "If this is the right answer we say correct!" +
                        "If this is the incorrect answer we say incorrect and a correct answer!"
                        +"If you want to exit from an introduction. please, click back to exit the introduction.", TextToSpeech.QUEUE_FLUSH, null);

                return true;
            }
        });

        questionLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = questionLabel.getText().toString();
                Text.speak(text, TextToSpeech.QUEUE_FLUSH, null);

            }
        });
        new CountDownTimer(50000, 1000) {

            public void onTick(long millisUntilFinished) {

            }
            public void onFinish() {
                Text.speak("Going back to the menu page", TextToSpeech.QUEUE_FLUSH, null);
                Main4Activity.super.onBackPressed();

            }
        }.start();



    }


    public void checkAnswer(View view) {
        Text.speak("You can long-click a button to listening to a choice!" +
                "when you click a button is mean you select this for an answer!" +
                "If this is the right answer we say correct!" +
                "If this is the incorrect answer we say incorrect and a correct answer!"
                +"If you want to exit from an introduction. please, click back to skip the introduction.", TextToSpeech.QUEUE_FLUSH, null);




        //CountDownTimer
        new CountDownTimer(2000, 1000) {

            public void onTick(long millisUntilFinished) {

            }
            public void onFinish() {


                answerBtn1.setBackgroundColor(Color.rgb(222, 222, 222));
                answerBtn2.setBackgroundColor(Color.rgb(222, 222, 222));
                answerBtn3.setBackgroundColor(Color.rgb(222, 222, 222));
                answerBtn4.setBackgroundColor(Color.rgb(222, 222, 222));


            }
        }.start();



    }


}

