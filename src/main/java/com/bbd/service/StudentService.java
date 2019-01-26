package com.bbd.service;

import com.bbd.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentService {
    List<Student> queryAll(int offset, int limit);
    void updateStudent(Student student);
    void deleteStudent(Student student);
    void insertStudent(Student student);
    Student queryId(int studentId);
    List<Student> TitleId(@Param("studentId") int studentId);
    List<Student> TitleName(@Param("studentN") String studentN);
}
