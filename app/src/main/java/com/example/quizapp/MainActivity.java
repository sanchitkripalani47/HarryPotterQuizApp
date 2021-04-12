package com.example.quizapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_FROM_QUIZ = 1;

 //   private Button startQuiz;
    public static final String SHARED_PREFS = "shared_prefs";
    public static final String KEY_HIGHSCORE = "keyHighScore";
    private TextView textHighScore;
    private int highScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textHighScore = findViewById(R.id.high_score);
        loadHighScore();

        Button startQuiz = findViewById(R.id.start_quiz_button);
        startQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuestions();
            }
        });
    }

    private void startQuestions() {
        Intent intent = new Intent(MainActivity.this, QuizActivity.class);
        startActivityForResult(intent, REQUEST_CODE_FROM_QUIZ);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_FROM_QUIZ){
            if (resultCode == RESULT_OK){
                int score = data.getIntExtra(QuizActivity.NEW_SCORE, 0);
                if (score > highScore){
                    updateHighScore(score);
                }
                else {
                    textHighScore.setText("Your Score: " + score + " HighScore: " +highScore);
                }
                if (score <= 5) {
                    Toast.makeText(MainActivity.this, "Are you sure you are not a muggle??", Toast.LENGTH_LONG).show();
                }
                else if (score <=10) {
                    Toast.makeText(MainActivity.this, "Squib alert!!!", Toast.LENGTH_LONG).show();
                }
                else if (score <=17) {
                    Toast.makeText(MainActivity.this, "You have achieved high marks!", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "True Potterhead", Toast.LENGTH_LONG).show();
                }
            }
        }
    }
    private void loadHighScore(){
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        highScore = prefs.getInt(KEY_HIGHSCORE, 0);
        textHighScore.setText("HighScore: " + highScore);
    }

    private void updateHighScore(int highScoreNew){
        highScore = highScoreNew;
        textHighScore.setText("HighScore: " + highScore);
        mySharedPrefs();
    }

    private void mySharedPrefs(){
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCORE, highScore);
        editor.apply();
    }
}