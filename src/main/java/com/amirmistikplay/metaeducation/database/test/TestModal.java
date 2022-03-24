package com.amirmistikplay.metaeducation.database.test;

public class TestModal {
        // variables for our coursename,
        // description, tracks and duration, id.
        private String courseId;
        private String courseQuestion;
        private String courseAnswer;
        private int id;

        // creating getter and setter methods
        public String getCourseId() {
            return courseId;
        }

        public void setCourseId(String courseName) {
            this.courseId = courseName;
        }

        public String getCourseQuestion() {
            return courseQuestion;
        }

        public void setCourseQuestion(String courseDuration) { this.courseQuestion = courseDuration; }
        
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
        public TestModal(String courseName, String courseQuestion, String courseAnswer) {
            this.courseId = courseName;
            this.courseQuestion = courseQuestion;
            this.courseAnswer = courseAnswer;
    }
}
