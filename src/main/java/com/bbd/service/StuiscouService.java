package com.bbd.service;

import com.bbd.entity.Stuiscou;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StuiscouService {
    /**
     * 查询所有教师的授课及选课学生
     * @param offset
     * @param limit
     * @return
     */
    List<Stuiscou> queryAllStudentiscou(@Param("offset")int offset, @Param("limit")int limit);

    /*查新所有学生的选课情况以及谈们对应的课程老师的信息*/

    List<Stuiscou> queryAllStuXuan(@Param("offset")int offset, @Param("limit")int limit);

    /**
     * 通过教师ID查询其授课和选课学生情况
     * @param teacherId
     * @return
     */
    List<Stuiscou> queryByTeacherId(int teacherId);

    /**
     * 通过学生ID查询课程
     * @param studentId
     * @return
     */
    List<Stuiscou> queryByStudentId(int studentId);





    /**
     * 通过学生ID查询其未选课程
     * @param stuId
     * @return
     */
    List<Stuiscou> countStudentId(int stuId);



    /**
     * 通过课程ID查询课余量
     * @param couId
     * @return
     */
    List<Stuiscou> countCourseId(int couId);


    /**
     * 学生退课
     */
    void delStudentCourse(Stuiscou stuiscou);

    /**
     * 学生选课
     */
    void addStudentCourse(Stuiscou stuiscou);
}
