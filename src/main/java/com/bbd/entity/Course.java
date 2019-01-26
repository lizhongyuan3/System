package com.bbd.entity;

public class Course {
    private int courseId;
    private String courseName;
    private int courseTime;
    private int courseTea;
//    一位老师教授一门课程
    private Teacher teacher;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(int courseTime) {
        this.courseTime = courseTime;
    }

    public int getCourseTea() {
        return courseTea;
    }

    public void setCourseTea(int courseTea) {
        this.courseTea = courseTea;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseTime=" + courseTime +
                ", courseTea=" + courseTea +
                '}';
    }
}
