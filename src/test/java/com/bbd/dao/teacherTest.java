package com.bbd.dao;


import com.bbd.entity.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class teacherTest {
    @Autowired
    private TeacherDao teacherDao;

    @Test
    public void testQueryAll() {
        List<Teacher> list;
        list = teacherDao.queryAll(0,100);
        for (Teacher teacher : list) {
            System.out.println(teacher);
        }
    }
    @Test
    public void updateuser() {
        Teacher teacher = new Teacher();
        teacher.setTeacherId(1011);
        teacher.setTeacherEdu("博士");
        teacher.setTeacherName("堕落天使");
        teacherDao.updateTeacher(teacher);
    }
    @Test
    public void deleteuser() {
        Teacher teacher = new Teacher();
        teacher.setTeacherId(1010);
        teacherDao.deleteTeacher(teacher);
    }
    @Test
    public void insertTeacher() {
        Teacher teacher = new Teacher();
        teacher.setTeacherName("魔蛇之佣");
        teacherDao.insertTeacher(teacher);
    }
    @Test
    public void queryId() {
        Teacher teacher=teacherDao.queryId(1001);
        System.out.println(teacher);
        System.out.println("--------------------------");
    }
}
