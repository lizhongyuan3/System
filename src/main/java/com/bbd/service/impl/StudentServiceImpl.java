package com.bbd.service.impl;

import com.bbd.dao.StudentDao;
import com.bbd.dao.StuiscouDao;
import com.bbd.entity.Student;
import com.bbd.entity.Stuiscou;
import com.bbd.service.StudentService;
import com.bbd.service.StuiscouService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private StuiscouService stuiscouService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public List<Student> queryAll(int offset, int limit) {
        logger.debug("开始查询教师................");
        List<Student>list=studentDao.queryAll(offset,limit);
        return list;
    }

    @Override
    public void updateStudent(Student student) {
        logger.debug("开始修改学生信息");
        studentDao.updateStudent(student);
    }

    @Override
    public void deleteStudent(Student student) {
        logger.debug("开始删除学生信息");
        studentDao.deleteStudent(student);
    }

    @Override
    public void insertStudent(Student student) {
        logger.debug("开始学生教师信息");
        studentDao.insertStudent(student);
    }

    @Override
    public Student queryId(int studentId) {
        logger.debug("开始根据学生学号查询");
        Student student=studentDao.queryId(studentId);
        return student;
    }

    @Override
    public List<Student> TitleId(int studentId) {
        logger.debug("开始根据学生学号模糊查询");
        List<Student> titleIdList=studentDao.TitleId(studentId);
        return titleIdList;
    }

    @Override
    public List<Student> TitleName(String studentN) {
            logger.debug("开始根据学生姓名模糊查询");
            List<Student> titleNameList=studentDao.TitleName(studentN);
            return titleNameList;

    }
}
