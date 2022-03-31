package com.amirmistikplay.metaeducation.database.test;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class TestDB extends SQLiteOpenHelper {
    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String DB_NAME = "testdb";

    // below int is our database version
    private static final int DB_VERSION = 1;

    // below variable is for our table name.
    private static final String TABLE_NAME = "mytests";

    // below variable is for our id column.
    private static final String ID_COL = "id";

    // below variable is for our course name column
    private static final String QUEST_COL = "question";

    // below variable id for our course duration column.
    private static final String ANSWER_COL = "answer";

    // creating a constructor for our database handler.
    public TestDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        // on below line we are creating
        // an sqlite query and we are
        // setting our column names
        // along with their data types.
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER,"
                + QUEST_COL + " TEXT,"
                + ANSWER_COL + " TEXT" + ")";

        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query);
    }

    // this method is use to add new course to our sqlite database.
    public void addNewCourse(int courseID, String courseQuestion, boolean courseAnswer) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(ID_COL, courseID);
        values.put(QUEST_COL, courseQuestion);
        values.put(ANSWER_COL, courseAnswer);

        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }

    // get courses
    public ArrayList<TestModal> GetQuestion(String question){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursorCourses;


        cursorCourses = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + QUEST_COL + " = '" + question + "'", null);

        ArrayList<TestModal> courseModalArrayList = new ArrayList<>();

        if (cursorCourses.moveToFirst()) {
            do {
                courseModalArrayList.add(new TestModal(cursorCourses.getString(0),
                        cursorCourses.getString(1),
                        cursorCourses.getString(2)));
            } while (cursorCourses.moveToNext());
        }
        cursorCourses.close();
        return courseModalArrayList;
    }

    // we have created a new method for reading all the courses.
    public ArrayList<TestModal> readCourses(int task_id) {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursorCourses;

        // on below line we are creating a cursor with query to read data from database.
        if(task_id == -1) {
            cursorCourses = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        } else {
            cursorCourses = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + ID_COL + " = " + task_id, null);
        }

        // on below line we are creating a new array list.
        ArrayList<TestModal> courseModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorCourses.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                courseModalArrayList.add(new TestModal(cursorCourses.getString(0),
                        cursorCourses.getString(1),
                        cursorCourses.getString(2)));
            } while (cursorCourses.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorCourses.close();
        return courseModalArrayList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
