package com.amirmistikplay.metaeducation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.amirmistikplay.metaeducation.database.test.TestDB;
import com.amirmistikplay.metaeducation.database.test.TestModal;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class TestActivity extends AppCompatActivity implements View.OnClickListener {

    private TestDB testdb;

    int task;

    TextView one, two, three, four, five;
    CheckBox one_check, two_check, three_check, four_check, five_check;
    CheckBox one_check_no, two_check_no, three_check_no, four_check_no, five_check_no;
    LinearLayout done;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.test_layout);
        Objects.requireNonNull(getSupportActionBar()).hide();
        init();
    }

    private void init(){
        ArrayList<TestModal> arrayListTest;

        testdb = new TestDB(TestActivity.this);

        task = getIntent().getIntExtra("task", 0);

        arrayListTest = testdb.readCourses(task);

        one = findViewById(R.id.first_q);
        two = findViewById(R.id.second_q);
        three = findViewById(R.id.third_q);
        four = findViewById(R.id.fourth_q);
        five = findViewById(R.id.fifth_q);

        done = findViewById(R.id.done_panel);

        one_check = findViewById(R.id.f_yes_one);
        two_check = findViewById(R.id.f_yes_two);
        three_check = findViewById(R.id.f_yes_three);
        four_check = findViewById(R.id.f_yes_fourth);
        five_check = findViewById(R.id.f_yes_fifth);

        one_check_no = findViewById(R.id.f_no_one);
        two_check_no = findViewById(R.id.f_no_two);
        three_check_no = findViewById(R.id.f_no_three);
        four_check_no = findViewById(R.id.f_no_fourth);
        five_check_no = findViewById(R.id.f_no_fifth);

        one.setText(getRandom(arrayListTest));
        two.setText(getRandom(arrayListTest));
        three.setText(getRandom(arrayListTest));
        four.setText(getRandom(arrayListTest));
        five.setText(getRandom(arrayListTest));

        one_check.setOnClickListener(this);
        two_check.setOnClickListener(this);
        three_check.setOnClickListener(this);
        four_check.setOnClickListener(this);
        five_check.setOnClickListener(this);

        one_check_no.setOnClickListener(this);
        two_check_no.setOnClickListener(this);
        three_check_no.setOnClickListener(this);
        four_check_no.setOnClickListener(this);
        five_check_no.setOnClickListener(this);

        done.setOnClickListener(this);
    }

    public static String getRandom(ArrayList<TestModal> array) {
        int rnd = new Random().nextInt(array.size());
        return String.valueOf(array.get(rnd).getCourseQuestion());
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.f_yes_one:
                one_check_no.setChecked(false);
                break;
            case R.id.f_yes_two:
                two_check_no.setChecked(false);
                break;
            case R.id.f_yes_three:
                three_check_no.setChecked(false);
                break;
            case R.id.f_yes_fourth:
                four_check_no.setChecked(false);
                break;
            case R.id.f_yes_fifth:
                five_check_no.setChecked(false);
                break;
            case R.id.f_no_one:
                one_check.setChecked(false);
                break;
            case R.id.f_no_two:
                two_check.setChecked(false);
                break;
            case R.id.f_no_three:
                three_check.setChecked(false);
                break;
            case R.id.f_no_fourth:
                four_check.setChecked(false);
                break;
            case R.id.f_no_fifth:
                five_check.setChecked(false);
                break;
            case R.id.done_panel:
                EndTest();
                break;
        }
    }

    private void EndTest(){
        String one_question, two_question, three_question, four_question, five_question;
        int one_answer, two_answer, three_answer, four_answer, five_answer;
        int first_answer_user, second_answer_user, three_answer_user, four_answer_user, five_answer_user;
        int total_score = 0;
        int get_id = 0;

        one_question = (String) one.getText();
        two_question = (String) two.getText();
        three_question = (String) three.getText();
        four_question = (String) four.getText();
        five_question = (String) five.getText();

        // GetQuestion
        testdb = new TestDB(TestActivity.this);

//        one_question = String.valueOf(testdb.GetQuestion(one_question).get(0).getCourseQuestion());
//        two_question = String.valueOf(testdb.GetQuestion(two_question).get(0).getCourseQuestion());
//        three_question = String.valueOf(testdb.GetQuestion(three_question).get(0).getCourseQuestion());
//        four_question = String.valueOf(testdb.GetQuestion(four_question).get(0).getCourseQuestion());
//        five_question = String.valueOf(testdb.GetQuestion(five_question).get(0).getCourseQuestion());

        get_id = Integer.parseInt(testdb.GetQuestion(one_question).get(0).getCourseId());

        one_answer = Integer.parseInt(testdb.GetQuestion(one_question).get(0).getCourseAnswer()); // 0
        two_answer = Integer.parseInt(testdb.GetQuestion(two_question).get(0).getCourseAnswer()); // 1
        three_answer = Integer.parseInt(testdb.GetQuestion(three_question).get(0).getCourseAnswer()); // 1
        four_answer = Integer.parseInt(testdb.GetQuestion(four_question).get(0).getCourseAnswer()); // 1
        five_answer = Integer.parseInt(testdb.GetQuestion(five_question).get(0).getCourseAnswer()); // 0

        first_answer_user = one_check.isChecked() ? 1 : 0; // 1
        second_answer_user = two_check.isChecked() ? 1 : 0; // 1
        three_answer_user = three_check.isChecked() ? 1 : 0; // 0
        four_answer_user = four_check.isChecked() ? 1 : 0; // 1
        five_answer_user = five_check.isChecked() ? 1 : 0; // 0

        if(one_answer == first_answer_user){
            total_score += 1;
        }
        if(two_answer == second_answer_user){
            total_score += 1;
        }
        if(three_answer == three_answer_user){
            total_score += 1;
        }
        if(four_answer == four_answer_user){
            total_score += 1;
        }
        if(five_answer == five_answer_user){
            total_score += 1;
        }

        Intent intent = new Intent(TestActivity.this, ResultActivity.class);
        intent.putExtra("score", total_score);
        intent.putExtra("id", get_id);
        startActivity(intent);
    }
}
