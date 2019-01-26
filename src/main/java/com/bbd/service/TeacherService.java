package com.bbd.service;

import com.bbd.entity.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> queryAll(int offset, int limit);
    void updateTeacher(Teacher teacher);
    void deleteTeacher(Teacher teacher);
    void insertTeacher(Teacher teacher);
    Teacher queryId(int teacherId);
}
