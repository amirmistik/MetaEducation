package com.amirmistikplay.metaeducation;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class ResultActivity extends AppCompatActivity {

    TextView balls;
    LinearLayout back;
    int get_ball, get_id;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_layout);
        Objects.requireNonNull(getSupportActionBar()).hide();

        get_ball = getIntent().getIntExtra("score", 0);
        get_id = getIntent().getIntExtra("id", 0); // for statistic

        balls = findViewById(R.id.mark_indicator);
        back = findViewById(R.id.done_task_panel);

        balls.setText(String.valueOf(get_ball));
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences statistic = getApplicationContext().getSharedPreferences("statistic", 0);
                SharedPreferences.Editor editor = statistic.edit();

                if(get_id == 0) {
                    editor.putInt("algebra", statistic.getInt("algebra", 0) + 1);
                } else if(get_id == 1) {
                    editor.putInt("geometry", statistic.getInt("geometry", 0) + 1);
                } else if(get_id == 2) {
                    editor.putInt("informatica", statistic.getInt("informatica", 0) + 1);
                }

                editor.apply();

                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
