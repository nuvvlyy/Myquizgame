package com.example.myquizgame;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
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

public class visibility extends AppCompatActivity {
    private TextView countLabel;
    private TextView questionLabel;
    private Button answerBtn1;
    private Button answerBtn2;
    private Button answerBtn3;
    private Button answerBtn4;

    private String rightAnswer;
    private int rightAnswerCount = 0;
    private int quizCount = 1;
    static final private int QUIZ_COUNT = 10;
    private TextToSpeech Text;

    ArrayList<ArrayList<String>> quizArray = new ArrayList<>();


    String quizData[][] = {
            // {"Country", "Right Answer", "Choice1", "Choice2", "Choice3"}
            {"What color are zebras?", "Black with white stripes.", "White with black stripes.", "Both of the above", "None of the above."},
            {"What is the 4th planet from the sun?", "Mars", "Mercury", "Earth", "Jupiter"},
            {"What color is a banana?", "Yellow", "Red", "White", "Pink"},
            {"How many sides does a square have?", "4", "2", "6", "8"},
            {"How many months do we have in a year?", "12", "18", "14", "16"},
            {"Which number comes after 5 ?", "6", "8", "10", "7"},
            {"Which day comes after Friday?", "Saturday", "Sunday", "Thursday", "Wednesday"},
            {"How many letters are there in the English alphabet?", "26", "44", "28", "32"},
            {"What do you call the person who brings a letter to your home from post office?", "Postman", "Chef", "Police", "Doctor"},
            {"What number comes after 9?", "10", "8", "4", "6"},
            {"What animal has a really long neck?", "A giraffe", " A parrot", "A gorilla", "A Monkey"},
            {"What time of day do we have breakfast?", "In the morning", " In the afternoon", " In the night", "In the evening"},
            {"What is the first color of a rainbow?", "Red", "Yellow","purple","blue"}
    };
    public void onBackPressed() {

        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visibility);

        Text  = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = Text.setLanguage(Locale.ENGLISH);

                    if (result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "Language not supported");
                    } else {
                        //answerBtn1.setEnabled(true);
                    }
                } else {
                    Log.e("TTS", "Initialization failed");
                }
            }
        });

        countLabel = (TextView)findViewById(R.id.countLabel);
        questionLabel = (TextView)findViewById(R.id.questionLabel);
        answerBtn1 = (Button)findViewById(R.id.answerBtn1);
        answerBtn2 = (Button)findViewById(R.id.answerBtn2);
        answerBtn3 = (Button)findViewById(R.id.answerBtn3);
        answerBtn4 = (Button)findViewById(R.id.answerBtn4);

        Text.setPitch(1);
        Text.setSpeechRate((float) 0.5);


        questionLabel.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                String text = questionLabel.getText().toString();
                Text.speak(text, TextToSpeech.QUEUE_FLUSH, null);
                return true;
            }
        });
        answerBtn1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                String text = answerBtn1.getText().toString();
                Text.speak(text, TextToSpeech.QUEUE_FLUSH, null);
                return true;
            }
        });
        answerBtn2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                String text = answerBtn2.getText().toString();
                Text.speak(text, TextToSpeech.QUEUE_FLUSH, null);
                return true;
            }
        });
        answerBtn3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                String text = answerBtn3.getText().toString();
                Text.speak(text, TextToSpeech.QUEUE_FLUSH, null);
                return true;
            }
        });
        answerBtn4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                String text = answerBtn3.getText().toString();
                Text.speak(text, TextToSpeech.QUEUE_FLUSH, null);
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

        // Create quizArray from quizData.
        for (int i = 0; i < quizData.length; i++) {
            // Prepare array.
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(quizData[i][0]);  // Country
            tmpArray.add(quizData[i][1]);  // Right Answer
            tmpArray.add(quizData[i][2]);  // Choice1
            tmpArray.add(quizData[i][3]);  // Choice2
            tmpArray.add(quizData[i][4]);  // Choice3

            // Add tmpArray to quizArray.
            quizArray.add(tmpArray);
        }

        showNextQuiz();

    }

    public void showNextQuiz() {
        answerBtn1.setBackgroundColor(Color.rgb(222, 222, 222));
        answerBtn2.setBackgroundColor(Color.rgb(222, 222, 222));
        answerBtn3.setBackgroundColor(Color.rgb(222, 222, 222));
        answerBtn4.setBackgroundColor(Color.rgb(222, 222, 222));

        // Update quizCountLabel.
        countLabel.setText("Q" + quizCount);

        // Generate random number between 0 and 14 (quizArray's size - 1).
        Random random = new Random();
        int randomNum = random.nextInt(quizArray.size());

        // Pick one quiz set.
        ArrayList<String> quiz = quizArray.get(randomNum);

        // Set question and right answer.
        // Array format: {"Country", "Right Answer", "Choice1", "Choice2", "Choice3"}
        questionLabel.setText(quiz.get(0));
        rightAnswer = quiz.get(1);

        // Remove "Country" from quiz and Shuffle choices.
        quiz.remove(0);
        Collections.shuffle(quiz);

        // Set Choices.
        answerBtn1.setText(quiz.get(0));
        answerBtn2.setText(quiz.get(1));
        answerBtn3.setText(quiz.get(2));
        answerBtn4.setText(quiz.get(3));
        //speak();

        // Remove this quiz from quizArray.
        quizArray.remove(randomNum);

    }
    public  void speak(){

        new CountDownTimer(500, 100) {

            public void onTick(long millisUntilFinished) {

            }
            public void onFinish() {
                String text = questionLabel.getText().toString();
                Text.speak(quizCount+ text, TextToSpeech.QUEUE_FLUSH, null);

            }
        }.start();
        new CountDownTimer(12000, 1000) {

            public void onTick(long millisUntilFinished) {

            }
            public void onFinish() {
                String text = answerBtn1.getText().toString();
                Text.speak("There are choices including ! 1 is "+answerBtn1.getText().toString()+"! 2 is"+answerBtn2.getText().toString()
                        +"! 3 is "+answerBtn3.getText().toString()+"! 4 is "+answerBtn4.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);

            }
        }.start();

    }
    public void checkAnswer(View view) {

        // Get pushed button.
        Button answerBtn = (Button) findViewById(view.getId());
        String btnText = answerBtn.getText().toString();

        String alertTitle;

        if (btnText.equals(rightAnswer)) {
            // Correct!
            alertTitle = "Correct!";
            Text.speak("Correct", TextToSpeech.QUEUE_FLUSH, null);

            answerBtn.setBackgroundColor(Color.rgb(57,149,82));
            rightAnswerCount++;
        } else {
            // Wrong...
            alertTitle = "Wrong...";
            answerBtn.setBackgroundColor(Color.rgb(230 ,30,30));
            if(answerBtn1.getText().toString().equals(rightAnswer)){
                answerBtn1.setBackgroundColor(Color.rgb(57,149,82));
            }else if(answerBtn2.getText().toString().equals(rightAnswer)) {
                answerBtn2.setBackgroundColor(Color.rgb(57, 149, 82));
            }else if(answerBtn3.getText().toString().equals(rightAnswer)){
                answerBtn3.setBackgroundColor(Color.rgb(57, 149, 82));
            }else{
                answerBtn4.setBackgroundColor(Color.rgb(57, 149, 82));
            }
            Text.speak("Correct is"+rightAnswer, TextToSpeech.QUEUE_FLUSH, null);
        }


        //CountDownTimer
        new CountDownTimer(3000, 1000) {

            public void onTick(long millisUntilFinished) {

            }
            public void onFinish() {

                if (quizCount == QUIZ_COUNT) {
                    // Show Result.
                    Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                    intent.putExtra("RIGHT_ANSWER_COUNT", rightAnswerCount);
                    startActivity(intent);

                } else {
                    quizCount++;
                    showNextQuiz();
                }

            }
        }.start();


    }

}
