package com.bbd.dao;

import com.bbd.entity.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class courseTest {
    @Autowired
    private CourseDao courseDao;

    @Test
    public void queryCourse(){
        List<Course> courses= courseDao.queryCourse(0,100);
        for(Course course: courses){
            System.out.println(course.toString()+course.getTeacher());
            System.out.println(course);
            System.out.println("该课程的老师为："+course.getTeacher());

        }
    }
    @Test
    public void queryByCourseId(){
        Course course=courseDao.queryByCourseId(123400);
        System.out.println(course.toString()+course.getTeacher());
    }
    @Test
    public void queryByTeacherId(){
        Course course=courseDao.queryByTeacherId(1010);
        System.out.println(course.getTeacher()+course.toString());
    }
}
