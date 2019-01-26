package com.bbd.entity;

public class Teacher {
    private int teacherId;
    private String teacherName;
    private String teacherEdu;
    private int delState;

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherEdu() {
        return teacherEdu;
    }

    public void setTeacherEdu(String teacherEdu) {
        this.teacherEdu = teacherEdu;
    }

    public int getDelState() {
        return delState;
    }

    public void setDelState(int delState) {
        this.delState = delState;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", teacherEdu='" + teacherEdu + '\'' +
                '}';
    }
}
