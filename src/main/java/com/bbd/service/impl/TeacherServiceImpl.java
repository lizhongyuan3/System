package com.bbd.service.impl;

import com.bbd.dao.TeacherDao;
import com.bbd.entity.Teacher;
import com.bbd.service.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TeacherDao teacherDao;
    @Override
    public List<Teacher> queryAll(int offset, int limit) {
        logger.debug("开始查询教师................");
        List<Teacher> list=teacherDao.queryAll(offset,limit);
        return list;
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        logger.debug("开始修改教师信息");
        teacherDao.updateTeacher(teacher);
    }

    @Override
    public void deleteTeacher(Teacher teacher) {
        logger.debug("开始删除教师信息");
        teacherDao.deleteTeacher(teacher);

    }

    @Override
    public void insertTeacher(Teacher teacher) {
        logger.debug("开始添加教师信息");
        teacherDao.insertTeacher(teacher);
    }

    @Override
    public Teacher queryId(int teacherId) {
        logger.debug("开始根据教师编号查询");
        Teacher teacher=teacherDao.queryId(teacherId);
        return teacher;
    }
}
