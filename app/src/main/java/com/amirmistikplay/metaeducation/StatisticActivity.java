package com.amirmistikplay.metaeducation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class StatisticActivity extends AppCompatActivity implements View.OnClickListener {

    ProgressBar algebra_progress, geometry_progress, informatics_progress;
    LinearLayout back;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statistic_layout);
        Objects.requireNonNull(getSupportActionBar()).hide();

        SharedPreferences statistic = getApplicationContext().getSharedPreferences("statistic", 0);
        SharedPreferences.Editor editor = statistic.edit();

        algebra_progress = findViewById(R.id.progressBarAlgebra);
        geometry_progress = findViewById(R.id.progressBarGeometry);
        informatics_progress = findViewById(R.id.progressBarInformatics);

        back = findViewById(R.id.back_from_statistic);

        algebra_progress.setProgress(statistic.getInt("algebra", 0));
        geometry_progress.setProgress(statistic.getInt("geometry", 0));
        informatics_progress.setProgress(statistic.getInt("informatica", 0));

        back.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.back_from_statistic:
                Intent intent = new Intent(StatisticActivity.this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}
