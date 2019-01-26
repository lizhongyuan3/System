package com.bbd.service.impl;

import com.bbd.dao.StuiscouDao;
import com.bbd.entity.Stuiscou;
import com.bbd.service.StuiscouService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StuiscouServiceImpl implements StuiscouService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private StuiscouDao stuiscouDao;
    @Override
    public List<Stuiscou> queryAllStudentiscou(int offset, int limit) {
        logger.debug("开始查询所有课程的选课情况：...............");
        List<Stuiscou> stuiscous =stuiscouDao.queryAllStudentiscou(0,100);
        return stuiscous;
    }

    @Override
    public List<Stuiscou> queryAllStuXuan(int offset, int limit) {
        logger.debug("开始查询学生的选课情况");
        List<Stuiscou> stuiscous=stuiscouDao.queryAllStuXuan(0,100);
        return stuiscous;
    }

    @Override
    public List<Stuiscou> queryByTeacherId(int teacherId) {
        logger.debug("开始查询某个教师的授课信息以及选课学生信息：...............");
        List<Stuiscou> stuiscou=stuiscouDao.queryByTeacherId(teacherId);
        return stuiscou;
    }

    @Override
    public List<Stuiscou> queryByStudentId(int studentId) {
        logger.debug("开始查询某个学生的选课信息：...............");
        List<Stuiscou> stuiscous=stuiscouDao.queryByStudentId(studentId);
        System.out.println("....");
        return stuiscous;
    }

    @Override
    public List<Stuiscou> countStudentId(int stuId) {
        logger.debug("开始根据学生的学号查询其未选课程......");
        List<Stuiscou> stuiscous=stuiscouDao.countStudentId(stuId);
        return stuiscous;
    }

    @Override
    public List<Stuiscou> countCourseId(int couId) {
        logger.debug("开始根据课程的课程号查询课程的剩余量....");
        List<Stuiscou> stuiscous=stuiscouDao.countCourseId(couId);
        return stuiscous;
    }

    @Override
    public void delStudentCourse(Stuiscou stuiscou) {
        logger.debug("开始退课操作.....");
        stuiscouDao.delStudentCourse(stuiscou);
    }

    @Override
    public void addStudentCourse(Stuiscou stuiscou) {
        logger.debug("开始选课操作.......");
        stuiscouDao.addStudentCourse(stuiscou);

    }
}
