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

public class GeometryActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout one, two, three, four, five;

    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.geometry_video_task);
        Objects.requireNonNull(getSupportActionBar()).hide();

        init();
    }

    private void init(){
        one = findViewById(R.id.first_panel_geometry);
        two = findViewById(R.id.second_panel_geometry);
        three = findViewById(R.id.three_panel_geometry);
        four = findViewById(R.id.four_panel_geometry);
        five = findViewById(R.id.five_panel_geometry);

        back = findViewById(R.id.menu_from_geometry);

        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);

        back.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        DBHandler dbHandler = new DBHandler(this);
        Intent OpenYoutube = new Intent(this, VideoActivity.class);
        ArrayList<CourseModal> courseModalArrayList = dbHandler.readCourses();
        switch (view.getId()) {
            case R.id.first_panel_geometry:
                OpenYoutube.putExtra("link", String.valueOf(courseModalArrayList.get(20).getCourseAnswer()));
                OpenYoutube.putExtra("task", String.valueOf(courseModalArrayList.get(22).getCourseName()));
                startActivity(OpenYoutube);
                break;
            case R.id.second_panel_geometry:
                OpenYoutube.putExtra("link", String.valueOf(courseModalArrayList.get(21).getCourseAnswer()));
                OpenYoutube.putExtra("task", String.valueOf(courseModalArrayList.get(22).getCourseName()));
                startActivity(OpenYoutube);
                break;
            case R.id.three_panel_geometry:
                OpenYoutube.putExtra("link", String.valueOf(courseModalArrayList.get(22).getCourseAnswer()));
                OpenYoutube.putExtra("task", String.valueOf(courseModalArrayList.get(22).getCourseName()));
                startActivity(OpenYoutube);
                break;
            case R.id.four_panel_geometry:
                OpenYoutube.putExtra("link", String.valueOf(courseModalArrayList.get(23).getCourseAnswer()));
                OpenYoutube.putExtra("task", String.valueOf(courseModalArrayList.get(22).getCourseName()));
                startActivity(OpenYoutube);
                break;
            case R.id.five_panel_geometry:
                OpenYoutube.putExtra("link", String.valueOf(courseModalArrayList.get(24).getCourseAnswer()));
                OpenYoutube.putExtra("task", String.valueOf(courseModalArrayList.get(22).getCourseName()));
                startActivity(OpenYoutube);
                break;
            case R.id.menu_from_geometry:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}
