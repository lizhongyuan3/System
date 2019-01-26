package com.bbd.dao;

import com.bbd.entity.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherDao {
    List<Teacher> queryAll(@Param("offset") int offset,@Param("limit") int limit);
    void updateTeacher(Teacher teacher);
    void deleteTeacher(Teacher teacher);
    void insertTeacher(Teacher teacher);
    Teacher queryId(int teacherId);
}
