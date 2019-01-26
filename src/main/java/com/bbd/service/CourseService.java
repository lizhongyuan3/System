package com.bbd.service;

import com.bbd.entity.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseService {
    /*
     * 查询所有的课程以及该课程所对应的老师的信息
     * */
    List<Course> queryCourse(@Param("offset")int offset, @Param("limit")int limit);
    /**
     * 通过课程号查询课程信息
     * @param courseId
     * @return
     */
    Course queryByCourseId(int courseId);

    /**
     * 通过教师ID差课程
     */

    Course queryByTeacherId(int teacherId);
}
