package com.bbd.web;


import com.bbd.entity.Stuiscou;
import com.bbd.service.StuiscouService;
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
@RequestMapping(value = "/xuan")
public class StuiscouController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private StuiscouService stuiscouService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(Model model, Integer offset, Integer limit) {
        logger.info("invoke----------/student/list");
        offset = offset == null ? 0 : offset;//默认便宜0
        limit = limit == null ? 50 : limit;//默认展示50条
        List<Stuiscou> list = stuiscouService.queryAllStudentiscou(offset, limit);
        model.addAttribute("stuiscoulist", list);
        return "stuiscou";
    }
    @RequestMapping(value = "/student",method = RequestMethod.GET)
    public String list1(Model model,Integer offer,Integer limit){
        logger.debug("开始显示学生的选课情况。。。。。。。。。。。。。。。。");
        offer=offer==null?0:offer;
        limit=limit==null?50:limit;
        List<Stuiscou> list=stuiscouService.queryAllStuXuan(offer,limit);
        model.addAttribute("studentIsCourseList",list);
        return "stuIsCourse";
    }
    @RequestMapping(value = "/course",method = RequestMethod.GET)
    public String list2(Model model,Integer offer,Integer limit){
        logger.debug("开始显示课程的选择情况............");
        offer=offer==null?0:offer;
        limit=limit==null?50:limit;
        List<Stuiscou> list=stuiscouService.queryAllStudentiscou(offer,limit);
        model.addAttribute("couIsStudentList",list);
        return "couIsStudent";
    }

    //学生已选择课程
    @RequestMapping(value = "/show",method = RequestMethod.GET)
    public String studentId(HttpSession session, Model model){
        logger.info("invoke--------------展示学生的已选课程");
        int studentId = (Integer)session.getAttribute("userId");
        List<Stuiscou> stuiscous=stuiscouService.queryByStudentId(studentId);
        if (stuiscous!=null&&!stuiscous.isEmpty()){
            model.addAttribute("okcourseInfo",stuiscous);
        }
        return "okcourse";
    }

    //学生退课
    @RequestMapping(value = "/delCourse",method = RequestMethod.POST)
    public String delStuCourse(Stuiscou stuiscou,HttpSession session,Model model) {
        logger.info("invoke----------------------退课操作");
        int studentId=(Integer)session.getAttribute("userId");
        stuiscou.setStuId(studentId);
        System.out.println(stuiscou.getCouId());
        System.out.println(stuiscou.getStuId());
        stuiscouService.delStudentCourse(stuiscou);
        model.addAttribute("msg","退课成功！");
        return "redirect:/xuan/show";
    }

    //学生未选课程
    @RequestMapping(value = "/noSelectCourse", method = RequestMethod.GET)
    public String noSelectCourse(HttpSession session,Model model) {
        logger.info("invoke----------------------展示未选课程");
        int studentId = (Integer)session.getAttribute("userId");
        List<Stuiscou> stuiscous = stuiscouService.countStudentId(studentId);
        model.addAttribute("noSelectCourseList",stuiscous);
        return "needcourse";
    }
    @RequestMapping(value = "/addCourse", method = RequestMethod.POST)
    public String addStuCourse(Stuiscou stuiscou, HttpSession session, Model model) {

        /* 传入的CouId 为<td><input class="common" type="text" name="couId"！！！！！！！！！！！！！切记*/
        logger.info("invoke----------------------选课操作");
        List<Stuiscou> list= stuiscouService.countCourseId(stuiscou.getCouId());
        int courseId=stuiscou.getCouId();
        System.out.println(list.size());
        System.out.println(stuiscou.getCouId());
        if (list.size()<10){
            int studentId=(Integer)session.getAttribute("userId");
            stuiscou.setStuId(studentId);
            stuiscouService.addStudentCourse(stuiscou);
            model.addAttribute("msg","选课成功！");
        }else {
            model.addAttribute("msg","选课失败，因为课余量不足！");
        }

        return "redirect:/xuan/noSelectCourse";
    }
}
