package com.bbd.dao;

import com.bbd.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class studentTest {

        @Autowired
        private StudentDao studentDao;

        @Test
        public void testQueryAll() {
            List<Student> list;
            list = studentDao.queryAll(0,100);
            for (Student student : list) {
                System.out.println(student);
            }
        }
    @Test
    public void updateuser() {
        Student student=new Student();
        student.setStudentName("白骨精");
        student.setStudentId(15101113);
        student.setStudentSex("女");
        student.setStudentLike("唐");
        studentDao.updateStudent(student);
    }
    @Test
    public void deleteStudent() {
        Student student=new Student();
        student.setStudentId(15101101);
        studentDao.deleteStudent(student);
    }
    @Test
    public void queryId() {
        Student student=studentDao.queryId(15101101);
        System.out.println(student);
        System.out.println("--------------------------");
    }

    @Test
    public void titleid() {
        List<Student> list= studentDao.TitleId(4);
        for(Student student:list){
            System.out.println(student);
        }
    }

    @Test
    public void titlename() {
        List<Student> list= studentDao.TitleName("僧");
        for(Student student:list){
            System.out.println(student);
        }
    }
}
