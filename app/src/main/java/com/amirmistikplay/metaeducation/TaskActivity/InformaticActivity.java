package com.amirmistikplay.metaeducation.TaskActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.amirmistikplay.metaeducation.MainActivity;
import com.amirmistikplay.metaeducation.R;
import com.amirmistikplay.metaeducation.VideoActivity;
import com.amirmistikplay.metaeducation.database.CourseModal;
import com.amirmistikplay.metaeducation.database.DBHandler;

import java.util.ArrayList;
import java.util.Objects;

public class InformaticActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout one, two, three, four, five, six, seven;

    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.informatics_video_task);
        Objects.requireNonNull(getSupportActionBar()).hide();

        init();
    }

    private void init(){
        one = findViewById(R.id.first_panel_informatics);
        two = findViewById(R.id.second_panel_informatics);
        three = findViewById(R.id.three_panel_informatics);
        four = findViewById(R.id.four_panel_informatics);
        five = findViewById(R.id.five_panel_informatics);
        six = findViewById(R.id.six_panel_informatics);
        seven = findViewById(R.id.seven_panel_informatics);

        back = findViewById(R.id.menu_from_informatics);

        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);

        back.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        DBHandler dbHandler = new DBHandler(this);
        Intent OpenYoutube = new Intent(this, VideoActivity.class);
        ArrayList<CourseModal> courseModalArrayList = dbHandler.readCourses();
        switch (view.getId()){
            case R.id.first_panel_informatics:
                OpenYoutube.putExtra("link", String.valueOf(courseModalArrayList.get(25).getCourseAnswer()));
                OpenYoutube.putExtra("task", String.valueOf(courseModalArrayList.get(27).getCourseName()));
                startActivity(OpenYoutube);
                break;
            case R.id.second_panel_informatics:
                OpenYoutube.putExtra("link", String.valueOf(courseModalArrayList.get(26).getCourseAnswer()));
                OpenYoutube.putExtra("task", String.valueOf(courseModalArrayList.get(27).getCourseName()));
                startActivity(OpenYoutube);
                break;
            case R.id.three_panel_informatics:
                OpenYoutube.putExtra("link", String.valueOf(courseModalArrayList.get(27).getCourseAnswer()));
                OpenYoutube.putExtra("task", String.valueOf(courseModalArrayList.get(27).getCourseName()));
                startActivity(OpenYoutube);
                break;
            case R.id.four_panel_informatics:
                OpenYoutube.putExtra("link", String.valueOf(courseModalArrayList.get(28).getCourseAnswer()));
                OpenYoutube.putExtra("task", String.valueOf(courseModalArrayList.get(27).getCourseName()));
                startActivity(OpenYoutube);
                break;
            case R.id.five_panel_informatics:
                OpenYoutube.putExtra("link", String.valueOf(courseModalArrayList.get(29).getCourseAnswer()));
                OpenYoutube.putExtra("task", String.valueOf(courseModalArrayList.get(27).getCourseName()));
                startActivity(OpenYoutube);
                break;
            case R.id.six_panel_informatics:
                OpenYoutube.putExtra("link", String.valueOf(courseModalArrayList.get(30).getCourseAnswer()));
                OpenYoutube.putExtra("task", String.valueOf(courseModalArrayList.get(27).getCourseName()));
                startActivity(OpenYoutube);
                break;
            case R.id.seven_panel_informatics:
                OpenYoutube.putExtra("link", String.valueOf(courseModalArrayList.get(31).getCourseAnswer()));
                OpenYoutube.putExtra("task", String.valueOf(courseModalArrayList.get(27).getCourseName()));
                startActivity(OpenYoutube);
                break;
            case R.id.menu_from_informatics:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}
