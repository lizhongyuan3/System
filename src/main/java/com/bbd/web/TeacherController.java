package com.bbd.web;

import com.bbd.entity.Course;
import com.bbd.entity.Student;
import com.bbd.entity.Stuiscou;
import com.bbd.entity.Teacher;
import com.bbd.service.CourseService;
import com.bbd.service.StuiscouService;
import com.bbd.service.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/teacher")
public class TeacherController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private  StuiscouService stuiscouService;
    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(Model model,Integer offset,Integer limit){
        logger.info("invoke----------/teacher/list");
        offset = offset == null ? 0 : offset;//默认便宜0
        limit = limit == null ? 50 : limit;//默认展示50条
        List<Teacher> list = teacherService.queryAll(offset, limit);
        model.addAttribute("teacherlist", list);
        return "info";
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String updateteacher(Teacher teacher) {
        logger.info("invoke--------------/teacher/update");
        teacherService.updateTeacher(teacher);
        return "redirect:/teacher/list";
    }
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteteacher(int teacherId){
        logger.info("invoke-------/teacher/delete");
        Teacher teacher=new Teacher();
        teacher.setTeacherId(teacherId);
        teacherService.deleteTeacher(teacher);
        return "redirect:/teacher/list";
    }
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String addteacher(Teacher teacher) {
        logger.info("invoke--------------/teacher/add");
        teacherService.insertTeacher(teacher);
        return "redirect:/teacher/list";
    }
    /* 查询教师的个人信息*/
    @RequestMapping(value = "/teacherId",method = RequestMethod.GET)
    public String teacherId(HttpSession session,Model model){
        logger.debug("开始查询教师的个人信息和授课情况");
        int teacherId=(Integer)session.getAttribute("userId");
        Course course =courseService.queryByTeacherId(teacherId);
        String teacherName=course.getTeacher().getTeacherName();
        /*session 保存查询到的姓名*/
        session.setAttribute("teacherName",teacherName);

        /*在控制台输出该姓名*//*
        System.out.println(session.getAttribute("teacherName"));*/

        List<Stuiscou> stuiscous=stuiscouService.queryByTeacherId(teacherId);
        model.addAttribute("teacherInfo",course);
        System.out.println(course);
        if(stuiscous!=null&&!stuiscous.isEmpty()){
            model.addAttribute("stuiscousInfo",stuiscous);
        }
        return "teacherInfo";
    }
    @RequestMapping(value = "/homeTS", method = RequestMethod.GET)
    public String toLogin1() {
        return "homeGood";
    }
    /*返回主页*/
    @RequestMapping(value = "/homeTea", method = RequestMethod.GET)
    public String toLogin() {
        return "homeTea";
    }
}
