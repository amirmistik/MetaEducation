package com.amirmistikplay.metaeducation.database;

public class CourseModal {
    // variables for our coursename,
    // description, tracks and duration, id.
    private String courseName;
    private String courseQuestion;
    private String courseAnswer;
    private int id;

    // creating getter and setter methods
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseQuestion() {
        return courseQuestion;
    }

    public void setCourseQuestion(String courseDuration) {
        this.courseQuestion = courseDuration;
    }

    public String getCourseAnswer() {
        return courseAnswer;
    }

    public void setCourseAnswer(String courseTracks) {
        this.courseAnswer = courseTracks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // constructor
    public CourseModal(String courseName, String courseQuestion, String courseAnswer) {
        this.courseName = courseName;
        this.courseQuestion = courseQuestion;
        this.courseAnswer = courseAnswer;
    }
}
