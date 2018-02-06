package com.example.khuyn.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final String KEY_INDEX = "index";

    private Button bTrue;
    private Button bFalse;
    private Button bNext;
    private TextView tvQuestion;
    private TextView tvHint;

    private Question[] mQuestionBank = new Question[]{
        new Question(R.string.question1, false, R.string.hint1),
        new Question(R.string.question2, false, R.string.hint2),
        new Question(R.string.question3, true, R.string.hint3),
        new Question(R.string.question4, true, R.string.hint4),
        new Question(R.string.question5, false, R.string.hint5),
        new Question(R.string.question6, true, R.string.hint6),
        new Question(R.string.question7, true, R.string.hint7),
        new Question(R.string.question8, true, R.string.hint8),
        new Question(R.string.question9, false, R.string.hint9),
        new Question(R.string.question10, false, R.string.hint10)

    };

    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "OnCreate() called");
        setContentView(R.layout.activity_main);

        tvHint = (TextView) findViewById(R.id.tvHint);

        if(savedInstanceState != null){
            counter = savedInstanceState.getInt(KEY_INDEX,0);
        }

        tvQuestion = (TextView) findViewById(R.id.tvQuestion);
        updateQuestion();

        bTrue = (Button) findViewById(R.id.bTrue);
        bTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(true);
            }
        });

        bFalse = (Button) findViewById(R.id.bFalse);
        bFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(false);
            }
        });

        bNext = (Button) findViewById(R.id.bNext);
        bNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter = (counter+1)%mQuestionBank.length;
                updateQuestion();
            }
        });
    }


    @Override
    public void onStart(){
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSavedInstanceState");
        savedInstanceState.putInt(KEY_INDEX, counter);
    }

    @Override
    public void onStop(){
        super.onStop();
        Log.d(TAG, "onStop() called");
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }

    private void updateQuestion(){
        int question = mQuestionBank[counter].getmTextResId();
        int hint = mQuestionBank[counter].getHint();
        tvQuestion.setText(question);
        tvHint.setText(hint);
    }

    private void checkAnswer(boolean userPressedTrue){
        boolean answerIsTrue = mQuestionBank[counter].ismAnswerTrue();

        int messageResId = 0;

        if(userPressedTrue == answerIsTrue){
            messageResId = R.string.correct_toast;
        }
        else{
            messageResId = R.string.incorrect_toast;
        }

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }
}
