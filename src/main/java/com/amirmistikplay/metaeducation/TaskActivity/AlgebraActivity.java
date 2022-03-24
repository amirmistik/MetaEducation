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
import com.amirmistikplay.metaeducation.database.ViewCourses;

import java.util.ArrayList;
import java.util.Objects;

public class AlgebraActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout one, two, three, four, five, six, seven, eight, nine, ten, eleven, twelve, thirdteen, fourteen, fifthteen, sixteen, seventeen, eighteen, nineteen, twenty;

    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.algebra_video_task);
        Objects.requireNonNull(getSupportActionBar()).hide();

        init();
    }

    private void init(){
        one = findViewById(R.id.first_panel_algebra);
        two = findViewById(R.id.second_panel_algebra);
        three = findViewById(R.id.three_panel_algebra);
        four = findViewById(R.id.four_panel_algebra);
        five = findViewById(R.id.five_panel_algebra);
        six = findViewById(R.id.six_panel_algebra);
        seven = findViewById(R.id.seven_panel_algebra);
        eight = findViewById(R.id.eight_panel_algebra);
        nine = findViewById(R.id.nine_panel_algebra);
        ten = findViewById(R.id.ten_panel_algebra);
        eleven = findViewById(R.id.eleven_panel_algebra);
        twelve = findViewById(R.id.twelve_panel_algebra);
        thirdteen = findViewById(R.id.threeteen_panel_algebra);
        fourteen = findViewById(R.id.fourteen_panel_algebra);
        fifthteen = findViewById(R.id.fifthteen_panel_algebra);
        sixteen = findViewById(R.id.sixteen_panel_algebra);
        seventeen = findViewById(R.id.seventeen_panel_algebra);
        eighteen = findViewById(R.id.eightteen_panel_algebra);
        nineteen = findViewById(R.id.nineteen_panel_algebra);
        twenty = findViewById(R.id.twenty_panel_algebra);

        back = findViewById(R.id.menu_from_algebra);

        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        ten.setOnClickListener(this);
        eleven.setOnClickListener(this);
        twelve.setOnClickListener(this);
        thirdteen.setOnClickListener(this);
        fourteen.setOnClickListener(this);
        fifthteen.setOnClickListener(this);
        sixteen.setOnClickListener(this);
        seventeen.setOnClickListener(this);
        eighteen.setOnClickListener(this);
        nineteen.setOnClickListener(this);
        twenty.setOnClickListener(this);

        back.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        DBHandler dbHandler = new DBHandler(this);
        Intent OpenYoutube = new Intent(this, VideoActivity.class);
        ArrayList<CourseModal> courseModalArrayList = dbHandler.readCourses();
        switch (view.getId()){
            case R.id.first_panel_algebra:
                OpenYoutube.putExtra("link", String.valueOf(courseModalArrayList.get(0).getCourseAnswer()));
                OpenYoutube.putExtra("task", String.valueOf(courseModalArrayList.get(0).getCourseName()));
                startActivity(OpenYoutube);
                break;
            case R.id.second_panel_algebra:
                OpenYoutube.putExtra("link", String.valueOf(courseModalArrayList.get(1).getCourseAnswer()));
                OpenYoutube.putExtra("task", String.valueOf(courseModalArrayList.get(0).getCourseName()));
                startActivity(OpenYoutube);
                break;
            case R.id.three_panel_algebra:
                OpenYoutube.putExtra("link", String.valueOf(courseModalArrayList.get(2).getCourseAnswer()));
                OpenYoutube.putExtra("task", String.valueOf(courseModalArrayList.get(0).getCourseName()));
                startActivity(OpenYoutube);
                break;
            case R.id.four_panel_algebra:
                OpenYoutube.putExtra("link", String.valueOf(courseModalArrayList.get(3).getCourseAnswer()));
                OpenYoutube.putExtra("task", String.valueOf(courseModalArrayList.get(0).getCourseName()));
                startActivity(OpenYoutube);
                break;
            case R.id.five_panel_algebra:
                OpenYoutube.putExtra("link", String.valueOf(courseModalArrayList.get(4).getCourseAnswer()));
                OpenYoutube.putExtra("task", String.valueOf(courseModalArrayList.get(0).getCourseName()));
                startActivity(OpenYoutube);
                break;
            case R.id.six_panel_algebra:
                OpenYoutube.putExtra("link", String.valueOf(courseModalArrayList.get(5).getCourseAnswer()));
                OpenYoutube.putExtra("task", String.valueOf(courseModalArrayList.get(0).getCourseName()));
                startActivity(OpenYoutube);
                break;
            case R.id.seven_panel_algebra:
                OpenYoutube.putExtra("link", String.valueOf(courseModalArrayList.get(6).getCourseAnswer()));
                OpenYoutube.putExtra("task", String.valueOf(courseModalArrayList.get(0).getCourseName()));
                startActivity(OpenYoutube);
                break;
            case R.id.eight_panel_algebra:
                OpenYoutube.putExtra("link", String.valueOf(courseModalArrayList.get(7).getCourseAnswer()));
                OpenYoutube.putExtra("task", String.valueOf(courseModalArrayList.get(0).getCourseName()));
                startActivity(OpenYoutube);
                break;
            case R.id.nine_panel_algebra:
                OpenYoutube.putExtra("link", String.valueOf(courseModalArrayList.get(8).getCourseAnswer()));
                OpenYoutube.putExtra("task", String.valueOf(courseModalArrayList.get(0).getCourseName()));
                startActivity(OpenYoutube);
                break;
            case R.id.ten_panel_algebra:
                OpenYoutube.putExtra("link", String.valueOf(courseModalArrayList.get(9).getCourseAnswer()));
                OpenYoutube.putExtra("task", String.valueOf(courseModalArrayList.get(0).getCourseName()));
                startActivity(OpenYoutube);
                break;
            case R.id.eleven_panel_algebra:
                OpenYoutube.putExtra("link", String.valueOf(courseModalArrayList.get(10).getCourseAnswer()));
                OpenYoutube.putExtra("task", String.valueOf(courseModalArrayList.get(0).getCourseName()));
                startActivity(OpenYoutube);
                break;
            case R.id.twelve_panel_algebra:
                OpenYoutube.putExtra("link", String.valueOf(courseModalArrayList.get(11).getCourseAnswer()));
                OpenYoutube.putExtra("task", String.valueOf(courseModalArrayList.get(0).getCourseName()));
                startActivity(OpenYoutube);
                break;
            case R.id.threeteen_panel_algebra:
                OpenYoutube.putExtra("link", String.valueOf(courseModalArrayList.get(12).getCourseAnswer()));
                OpenYoutube.putExtra("task", String.valueOf(courseModalArrayList.get(0).getCourseName()));
                startActivity(OpenYoutube);
                break;
            case R.id.fourteen_panel_algebra:
                OpenYoutube.putExtra("link", String.valueOf(courseModalArrayList.get(13).getCourseAnswer()));
                OpenYoutube.putExtra("task", String.valueOf(courseModalArrayList.get(0).getCourseName()));
                startActivity(OpenYoutube);
                break;
            case R.id.fifthteen_panel_algebra:
                OpenYoutube.putExtra("link", String.valueOf(courseModalArrayList.get(14).getCourseAnswer()));
                OpenYoutube.putExtra("task", String.valueOf(courseModalArrayList.get(0).getCourseName()));
                startActivity(OpenYoutube);
                break;
            case R.id.sixteen_panel_algebra:
                OpenYoutube.putExtra("link", String.valueOf(courseModalArrayList.get(15).getCourseAnswer()));
                OpenYoutube.putExtra("task", String.valueOf(courseModalArrayList.get(0).getCourseName()));
                startActivity(OpenYoutube);
                break;
            case R.id.seventeen_panel_algebra:
                OpenYoutube.putExtra("link", String.valueOf(courseModalArrayList.get(16).getCourseAnswer()));
                OpenYoutube.putExtra("task", String.valueOf(courseModalArrayList.get(0).getCourseName()));
                startActivity(OpenYoutube);
                break;
            case R.id.eightteen_panel_algebra:
                OpenYoutube.putExtra("link", String.valueOf(courseModalArrayList.get(17).getCourseAnswer()));
                OpenYoutube.putExtra("task", String.valueOf(courseModalArrayList.get(0).getCourseName()));
                startActivity(OpenYoutube);
                break;
            case R.id.nineteen_panel_algebra:
                OpenYoutube.putExtra("link", String.valueOf(courseModalArrayList.get(18).getCourseAnswer()));
                OpenYoutube.putExtra("task", String.valueOf(courseModalArrayList.get(0).getCourseName()));
                startActivity(OpenYoutube);
                break;
            case R.id.twenty_panel_algebra:
                OpenYoutube.putExtra("link", String.valueOf(courseModalArrayList.get(19).getCourseAnswer()));
                OpenYoutube.putExtra("task", String.valueOf(courseModalArrayList.get(0).getCourseName()));
                startActivity(OpenYoutube);
                break;
            case R.id.menu_from_algebra:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}