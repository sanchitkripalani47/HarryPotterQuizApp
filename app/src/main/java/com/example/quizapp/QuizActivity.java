package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Collections;
import java.util.List;

public class QuizActivity extends AppCompatActivity {
    public static final String NEW_SCORE = "newScore";

    private TextView scoreView;
    private TextView questionViewCount;
    private TextView questionTextView;
    private RadioGroup rdg;
    private RadioButton rdb1;
    private RadioButton rdb2;
    private RadioButton rdb3;
    private RadioButton rdb4;
    private Button confirmButton;

    private List<Question> questionList;

    private Question currentQuestion;
    private int totalQuestions;
    private int currentQuestionNumber;
    private int score;
    private boolean answered;
    private long backPressedTime;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        scoreView = findViewById(R.id.score_id);
        questionViewCount = findViewById(R.id.question_number);
        questionTextView = findViewById(R.id.questionText);
        rdg = findViewById(R.id.radio_group);
        rdb1 = findViewById(R.id.radio_option1);
        rdb2 = findViewById(R.id.radio_option2);
        rdb3 = findViewById(R.id.radio_option3);
        rdb4 = findViewById(R.id.radio_option4);
        confirmButton = findViewById(R.id.submit_button);

        QuizHelper quizHelper = new QuizHelper(this);
        questionList = quizHelper.getAllQuestions();
        totalQuestions = questionList.size();
        Collections.shuffle(questionList);

        confirmButton.setText("Revelio");
        showNextQuestion();

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answered){
                    if (rdb1.isChecked() || rdb2.isChecked() || rdb3.isChecked() || rdb4.isChecked() ){
                        checkAnswer();
                    }
                    else {
                        Toast.makeText(QuizActivity.this, "Select one answer", Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    showNextQuestion();
                }
            }
        });
    }

    private void showNextQuestion() {
        rdg.clearCheck();

        if (currentQuestionNumber < totalQuestions){
            confirmButton.setText("Revelio");
            currentQuestion = (questionList.get(currentQuestionNumber));
            questionTextView.setText(currentQuestion.getQuestion());
            rdb1.setText(currentQuestion.getOption1());
            rdb2.setText(currentQuestion.getOption2());
            rdb3.setText(currentQuestion.getOption3());
            rdb4.setText(currentQuestion.getOption4());
            currentQuestionNumber++;

            questionViewCount.setText("Question: " + currentQuestionNumber + "/" + totalQuestions);
            answered = false;

        }
        else {
            finishQuiz();
        }
    }

    private void checkAnswer() {
        answered = true;
        RadioButton rbSelected = findViewById(rdg.getCheckedRadioButtonId());
        int answerNum = rdg.indexOfChild(rbSelected) + 1;

        if (answerNum == currentQuestion.getAnswerNum()){
            score++;
            scoreView.setText("Score: " + score);
        }
        showSolution();
    }

    private void showSolution() {
        switch(currentQuestion.getAnswerNum()) {
            case 1:
                Toast.makeText(QuizActivity.this, "Option 1 is correct. Click again to get the next question", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(QuizActivity.this, "Option 2 is correct. Click again to get the next question ", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(QuizActivity.this, "Option 3 is correct. Click again to get the next question ", Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Toast.makeText(QuizActivity.this, "Option 4 is correct. Click again to get the next question ", Toast.LENGTH_SHORT).show();
                break;
        }

        if (currentQuestionNumber < totalQuestions){
            confirmButton.setText("Next");
        }
        else {
            confirmButton.setText("Finish");
        }
    }


    private void finishQuiz() {
        Intent result = new Intent();
        result.putExtra(NEW_SCORE, score);
        setResult(RESULT_OK, result);
        finish();
    }

    @Override
    public void onBackPressed() {
            if (backPressedTime + 2000 > System.currentTimeMillis()) {
                finishQuiz();
            }
            else {
                Toast.makeText(this, "Press Again to Exit", Toast.LENGTH_SHORT).show();
            }
            backPressedTime = System.currentTimeMillis();
    }
}
