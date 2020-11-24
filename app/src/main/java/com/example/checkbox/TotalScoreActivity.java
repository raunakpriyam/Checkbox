package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class TotalScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_score);

        int totalScore = getIntent().getIntExtra("totalScore",-1);

        TextView tvTotal = findViewById(R.id.tvTotalScore);

        tvTotal.setText(String.valueOf(totalScore));


    }
}