package com.example.khuyn.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HintActivity extends AppCompatActivity {
    private TextView tvHint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint);

        tvHint = (TextView) findViewById(R.id.tvHint);
        tvHint.setText(MainActivity.displayHint);
    }
}
