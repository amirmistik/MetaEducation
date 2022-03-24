package com.amirmistikplay.metaeducation;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.amirmistikplay.metaeducation.database.CourseModal;
import com.amirmistikplay.metaeducation.database.test.TestDB;
import com.amirmistikplay.metaeducation.database.DBHandler;
import com.amirmistikplay.metaeducation.database.test.TestModal;
import com.amirmistikplay.metaeducation.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private DBHandler dbHandler;
    private TestDB testdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Objects.requireNonNull(getSupportActionBar()).hide();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigatin_view);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.homeFragment, R.id.taskFragment).build();
        NavController navController = Navigation.findNavController(this, R.id.nav_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.bottomNavigatinView, navController);

        init();
        DataBaseInit();
        setMoneyText();
    }

    private void DataBaseInit(){
        dbHandler = new DBHandler(MainActivity.this);
        ArrayList<CourseModal> arrayList = dbHandler.readCourses();
        if(arrayList.isEmpty()){
            //Алгебра
            dbHandler.addNewCourse("Алгебра", "TtM_sNqBF4I", "0");
            dbHandler.addNewCourse("Алгебра", "nVdrcGs9LnQ", "0");
            dbHandler.addNewCourse("Алгебра", "WfoumSADFFc", "0");
            dbHandler.addNewCourse("Алгебра", "Razdc5Palss", "0");
            dbHandler.addNewCourse("Алгебра", "joPHReSJ-AM", "0");
            dbHandler.addNewCourse("Алгебра", "NcPmZpQ9kXw", "0");
            dbHandler.addNewCourse("Алгебра", "DKWVvPiAXpI", "0");
            dbHandler.addNewCourse("Алгебра", "1OJiyT4xz5g", "0");
            dbHandler.addNewCourse("Алгебра", "yhJ9xeo_W8c", "0");
            dbHandler.addNewCourse("Алгебра", "zLeui6ttjdU", "0");
            dbHandler.addNewCourse("Алгебра", "5CvOCC1Y7ZA", "0");
            dbHandler.addNewCourse("Алгебра", "XMqp5p950jo", "0");
            dbHandler.addNewCourse("Алгебра", "eP7xHnxrehc", "0");
            dbHandler.addNewCourse("Алгебра", "MzGbb7Xp9AQ", "0");
            dbHandler.addNewCourse("Алгебра", "Vo-2s6izfNA", "0");
            dbHandler.addNewCourse("Алгебра", "Vo-2s6izfNA", "0");
            dbHandler.addNewCourse("Алгебра", "hOmLzXC-cPM", "0");
            dbHandler.addNewCourse("Алгебра", "Vqpy4jnRQZc", "0");
            dbHandler.addNewCourse("Алгебра", "UZ53oHNmX50", "0");
            dbHandler.addNewCourse("Алгебра", "Dykd5cUbLVU", "0");
            dbHandler.addNewCourse("Алгебра", "mQo_QdXNykY", "0");
            //Геометрия
            dbHandler.addNewCourse("Геометрия", "F1tawqG6xyw", "1");
            dbHandler.addNewCourse("Геометрия", "WfoumSADFFc", "1");
            dbHandler.addNewCourse("Геометрия", "x7zeRCn_-0o", "1");
            dbHandler.addNewCourse("Геометрия", "OpplfbrFsYM", "1");
            dbHandler.addNewCourse("Геометрия", "DKWVvPiAXpI", "1");
            //Информатика
            dbHandler.addNewCourse("Информатика", "fp5-XQFr_nk", "2");
            dbHandler.addNewCourse("Информатика", "4E8sr4QS7OI", "2");
            dbHandler.addNewCourse("Информатика", "5pBcKKiZSGE", "2");
            dbHandler.addNewCourse("Информатика", "iPV5GKeHyV4", "2");
            dbHandler.addNewCourse("Информатика", "joPHReSJ-AM", "2");
            dbHandler.addNewCourse("Информатика", "a6xtQQqx1tg", "2");
            dbHandler.addNewCourse("Информатика", "KmTK8kub_gw", "2");
        }
        testdb = new TestDB(MainActivity.this);
        ArrayList<TestModal> arrayListTest = testdb.readCourses(-1);
        if(arrayListTest.isEmpty()){
            //algebra
            testdb.addNewCourse(0, "In an acute-angled triangle, all angles are sharp", true);
            testdb.addNewCourse(0, "In any obtuse triangle there is an acute angle", true);
            testdb.addNewCourse(0, "One of the angles of the triangle always does not exceed 60", true);
            testdb.addNewCourse(0, "The outer corner of the triangle is no longer the adjacent inner corner", true);
            testdb.addNewCourse(0, "A triangle with sides 1,9,9 exists", true);
            testdb.addNewCourse(0, "In a triangle against the larger side lies a larger angle", true);
            testdb.addNewCourse(0, "In a triangle against a larger angle lies the larger side", true);
            testdb.addNewCourse(0, "The median perpendiculars to the sides of the triangle intersect in the center of its circumscribed circle", true);
            testdb.addNewCourse(0, "A single straight line can be drawn through a given point in the plane.", false);
            testdb.addNewCourse(0, "Two straight lines parallel to the third straight line are perpendicular to each other", false);
            testdb.addNewCourse(0, "Two straight lines perpendicular to the third straight line are perpendicular to each other", false);
            testdb.addNewCourse(0, "Adjacent angles are equal", false);
            testdb.addNewCourse(0, "If the angle is acute , then the angle adjacent to it is also acute", false);
            testdb.addNewCourse(0, "One of the two adjacent corners is sharp, and the other is blunt", false);
            testdb.addNewCourse(0, "At the intersection of two parallel straight lines of the secant , all the intersecting angles are equal", false);
            // geometry
            testdb.addNewCourse(1, "Through a point that does not lie on this line, you can draw a line parallel to this line.", true);
            testdb.addNewCourse(1, "Through a point that does not lie on this line, you can draw a line perpendicular to this line.", true);
            testdb.addNewCourse(1, "There are three straight lines that pass through one point.", true);
            testdb.addNewCourse(1, "Two straight lines on a plane perpendicular to the third straight line are parallel to each other.", true);
            testdb.addNewCourse(1, "A point that does not lie at the midpoint perpendicular to the segment is equidistant from the ends of this segment.", true);
            testdb.addNewCourse(1, "The vertical angles are equal.", true);
            testdb.addNewCourse(1, "If a point lies on the bisector of an angle, then it is equidistant from the sides of this angle.", true);
            testdb.addNewCourse(1, "The angle between the bisectors of the vertical angles is 180", true);
            testdb.addNewCourse(1, "At the intersection of two parallel straight lines of the secant, the sum of one-sided angles is 180", true);
            testdb.addNewCourse(1, "The sum of the angles of any triangle of a triangle is 180", true);
            testdb.addNewCourse(1, "If there is one acute angle in a triangle, then this triangle is acute-angled", false);
            testdb.addNewCourse(1, "The sum of the angles of any triangle of a triangle is 360", false);
            testdb.addNewCourse(1, "In an obtuse triangle, all angles are obtuse", false);
            testdb.addNewCourse(1, "The outer angle of a triangle is equal to the sum of its inner angles", false);
            testdb.addNewCourse(1, "The median of the triangle divides in half the angle from which the", false);
            testdb.addNewCourse(1, "The bisector of a triangle bisects the side to which it is drawn", false);
            testdb.addNewCourse(1, "A triangle with sides 1,3,5 exists", false);
            testdb.addNewCourse(1, "If two sides of one triangle are respectively equal to two sides of another triangle, then such triangles are equal", false);
            testdb.addNewCourse(1, "If the three corners of one triangle are equal to the three corners of the other triangle , respectively , then such triangles are equal", false);
            testdb.addNewCourse(1, "If two sides and the angle of one triangle are equal , respectively , to two sides and the angle of one triangle , then such triangles are equal", false);
            // informatics
            testdb.addNewCourse(2, "HTML is a markup language?", true);
            testdb.addNewCourse(2, "CSS is a formal language for describing the appearance of a document?", true);
            testdb.addNewCourse(2, "Python is an interpreted programming language?", true);
            testdb.addNewCourse(2, "A high-level programming language is a programming language designed for speed and ease of use by a programmer?", true);
            testdb.addNewCourse(2, "The Python file has an extension .py?", true);
            testdb.addNewCourse(2, "The Java file has an extension .js?", false);
            testdb.addNewCourse(2, "Is JavaScript only used to create websites?", false);
            testdb.addNewCourse(2, "Is SQL used to create databases?", true);
            testdb.addNewCourse(2, "Is Tkinter a library for creating python applications?", true);
            testdb.addNewCourse(2, "Is Kivy a library for creating python applications?", true);
        }
        arrayListTest = testdb.readCourses(-1);
        System.out.println(arrayListTest);
    }

    private void init(){
        SharedPreferences settings = getApplicationContext().getSharedPreferences("wallet", 0);
        if(!settings.contains("meta")){
            SharedPreferences.Editor editor = settings.edit();
            editor.putInt("meta", 0);
            editor.apply();
        }
        SharedPreferences statistic = getApplicationContext().getSharedPreferences("statistic", 0);
        if(!statistic.contains("algebra") | !statistic.contains("geometry") | !statistic.contains("informatica")){
            SharedPreferences.Editor editor = statistic.edit();

            editor.putInt("algebra", 0);
            editor.putInt("geometry", 0);
            editor.putInt("informatica", 0);

            editor.apply();
        }
    }

    private void setMoneyText(){
        SharedPreferences settings = getApplicationContext().getSharedPreferences("wallet", 0);
        int money = settings.getInt("meta", 0);
        TextView MetaCoin = findViewById(R.id.metacoin);
        MetaCoin.setText(String.valueOf(money));
    }
}