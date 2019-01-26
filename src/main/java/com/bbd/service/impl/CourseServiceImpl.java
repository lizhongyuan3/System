package com.bbd.service.impl;

import com.bbd.dao.CourseDao;
import com.bbd.entity.Course;
import com.bbd.service.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CourseDao courseDao;
    @Override
    public List<Course> queryCourse(int offset, int limit) {
        logger.debug("开始查询所有课程的课程信息：...............");
        List<Course> courses =courseDao.queryCourse(0,100);
        return courses;
    }

    @Override
    public Course queryByCourseId(int courseId) {
        logger.debug("开始查询某个课程的课程信息：...............");
        Course course=courseDao.queryByCourseId(courseId);
        return course;
    }

    @Override
    public Course queryByTeacherId(int teacherId) {
        logger.debug("开始查询某个教师的课程信息：...............");
        Course course=courseDao.queryByTeacherId(teacherId);
        return course;
    }
}
