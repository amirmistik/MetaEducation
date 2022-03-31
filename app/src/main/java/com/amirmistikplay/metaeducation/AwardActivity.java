package com.amirmistikplay.metaeducation;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class AwardActivity extends AppCompatActivity {

    int first_award, second_award, third_award;

    ImageView first_award_image, second_award_image, third_award_image;

    Button back;

    TextView metacoin;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.award_layout);
        Objects.requireNonNull(getSupportActionBar()).hide();

        setMoneyText();
        init();
    }

    private void setMoneyText(){
        SharedPreferences settings = getApplicationContext().getSharedPreferences("wallet", 0);
        int money = settings.getInt("meta", 0);
        metacoin = findViewById(R.id.metacoin);
        metacoin.setText(String.valueOf(money));
    }

    private void init(){
        SharedPreferences settings = getApplicationContext().getSharedPreferences("statistic", 0); // open award save

        back = findViewById(R.id.back_from_award); // find back button

        first_award = settings.getInt("algebra", 0);
        second_award = settings.getInt("geometry", 0);
        third_award = settings.getInt("informatica", 0);

        first_award_image = findViewById(R.id.full_algebra_complete);
        second_award_image = findViewById(R.id.full_geometry_complete);
        third_award_image = findViewById(R.id.full_informatica_complete);

        if(first_award < 10){
            first_award_image.setVisibility(View.GONE);
        } else {
            first_award_image.setVisibility(View.VISIBLE);
        }
        if (second_award < 10){
            second_award_image.setVisibility(View.GONE);
        } else {
            second_award_image.setVisibility(View.VISIBLE);
        }
        if (third_award < 10){
            third_award_image.setVisibility(View.GONE);
        } else {
            third_award_image.setVisibility(View.VISIBLE);
        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AwardActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
