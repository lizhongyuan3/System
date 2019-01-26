package com.bbd.dao;


import com.bbd.entity.Course;
import com.bbd.entity.Student;
import com.bbd.entity.Stuiscou;
import com.bbd.entity.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class StuiscouTest {

    @Autowired
    private StuiscouDao stuiscouDao;

    @Test
    public void queryAllStudentiscou(){
        List<Stuiscou> stuiscous=stuiscouDao.queryAllStudentiscou(0,100);
        for (Stuiscou stuiscou: stuiscous){
            for (Student student : stuiscou.getStudents() ){
                System.out.println(stuiscou.getTeacher()+stuiscou.toString()+stuiscou.getCourse()+student);

               /* System.out.println(student+stuiscou.toString()+stuiscou.getCourse()+stuiscou.getTeacher());*/
            }
        }
    }

    @Test
    public void queryAllStuXuan(){
        List<Stuiscou> stuiscous=stuiscouDao.queryAllStuXuan(0,100);
        for(Stuiscou stuiscou:stuiscous){
            for(Course course: stuiscou.getCourses()){
                /*System.out.println(stuiscou.getStudent()+stuiscou.toString()+course+stuiscou.getCourse().getTeacher());*/
                System.out.println(stuiscou.getStudent()+stuiscou.toString()+course);

            }
        }
    }
    @Test
    public void queryAllStuXuan2(){
        List<Stuiscou> stuiscous=stuiscouDao.queryAllStuXuan(0,100);
        for(Stuiscou stuiscou:stuiscous){
            for(Teacher teacher:stuiscou.getTeachers()){
                /*System.out.println(stuiscou.getStudent()+stuiscou.toString()+course+stuiscou.getCourse().getTeacher());*/
                System.out.println(stuiscou.getStudent()+stuiscou.toString()+teacher);

            }
        }
    }

    @Test
    public void queryByTeacherId(){
        List<Stuiscou> stuiscous =stuiscouDao.queryByTeacherId(1000);
        for (Stuiscou stuiscou: stuiscous)
        {
            for (Student student : stuiscou.getStudents() ){
                System.out.println(student);
            }
        }
    }

    @Test
    public void queryByStudentId(){
        List<Stuiscou> stuiscous=stuiscouDao.queryByStudentId(15101101);
        for (Stuiscou stuiscou : stuiscous){
            for (Student student : stuiscou.getStudents() ){
                System.out.println(student+stuiscou.toString()+stuiscou.getCourse()+stuiscou.getTeacher());
            }
        }
    }


    @Test
    public void countStudentId(){
//        在这个查询里面用的是stuiscou当作子查询，stuiscou的值并不能显示出来！！！！！！！！！！！！！！！！！！！！！！
        List<Stuiscou> stuiscous=stuiscouDao.countStudentId(15101113);
        for (Stuiscou stuiscou : stuiscous){
            System.out.println(stuiscou.getCourse().toString());
            System.out.println(stuiscou.toString());
            System.out.println(stuiscou.getTeacher().toString());
        }
    }
    @Test
    public void countCourseId(){
        List<Stuiscou> stuiscous=stuiscouDao.countCourseId(123400);
        for (Stuiscou stuiscou : stuiscous){
            System.out.println(stuiscou);
        }
    }
    @Test
    public void delStudentCourse() {
        Stuiscou stuiscou=new Stuiscou();
        stuiscou.setCouId(123410);
        stuiscou.setStuId(15101113);
        stuiscouDao.delStudentCourse(stuiscou);
    }
    @Test
    public void addStudentCourse(){
        Stuiscou stuiscou=new Stuiscou();
        stuiscou.setStuId(15101113);
        stuiscou.setCouId(123410);
        stuiscouDao.addStudentCourse(stuiscou);
    }
}
