package com.bbd.web;

import com.bbd.entity.Student;
import com.bbd.entity.Stuiscou;
import com.bbd.service.CourseService;
import com.bbd.service.StudentService;
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
@RequestMapping(value = "/student")
public class StudentController {

        private final Logger logger = LoggerFactory.getLogger(this.getClass());
        @Autowired
        private StudentService studentService;
        @Autowired
        private CourseService courseService;
        @Autowired
        private StuiscouService stuiscouService;

        @RequestMapping(value = "/list",method = RequestMethod.GET)
        public String list(Model model, Integer offset, Integer limit){
            logger.info("invoke----------/student/list");
            offset = offset == null ? 0 : offset;//默认便宜0
            limit = limit == null ? 50 : limit;//默认展示50条
            List<Student> list = studentService.queryAll(offset, limit);
            model.addAttribute("stuentlist", list);
            return "student";
        }
    @RequestMapping(value = "/list2",method = RequestMethod.GET)
    public String list2(Model model, Integer offset, Integer limit){
        logger.info("invoke----------显示学生信息");
        offset = offset == null ? 0 : offset;//默认便宜0
        limit = limit == null ? 50 : limit;//默认展示50条
        List<Student> list = studentService.queryAll(offset, limit);
        model.addAttribute("stuentlist", list);
        return "student.tea";
    }

    @RequestMapping(value = "/queryByStudentId",method = RequestMethod.POST)
    public String queryByStudentId(int studentId,Model model) {
        logger.info("invoke----------------------Id 模糊查询");
        List<Student> titleIdList=studentService.TitleId(studentId);

//采用动态SQL 当输入空值是查询全部
        //titleIdList.isEmpty()和 titleIdList.size()==0 均可判断数组是否为空，size属于有杯子没有水和isEmpty 应该一样。。
       if(titleIdList.size()==0){
            model.addAttribute("msg","对不起，你所查询的信息不存在！");
       }else {
              model.addAttribute("titleIdList",titleIdList);
          }
        return "student.tea";
    }


    @RequestMapping(value = "/queryByStudentName",method = RequestMethod.POST)
    public String queryByStudentName(String studentName,Model model) {
        logger.info("invoke----------------------Name 模糊查询");
        List<Student> titleNameList=studentService.TitleName(studentName);
        if(titleNameList.size()==0){
            model.addAttribute("msg","对不起，你所查询的信息不存在！");
        }else {
            model.addAttribute("titleNameList",titleNameList);
        }
        return "student.tea";
    }
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String updateteacher(Student student) {
        logger.info("invoke--------------/student/update");
        studentService.updateStudent(student);
        return "redirect:/student/list";
    }


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteteacher(int studentId){
        logger.info("invoke-------/student/delete");
        Student student=new Student();
        student.setStudentId(studentId);
        studentService.deleteStudent(student);
        return "redirect:/student/list";
    }
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String addstudent(Student student) {
        logger.info("invoke--------------/student/add");
        studentService.insertStudent(student);
        return "redirect:/student/list";
    }
    @RequestMapping(value = "/studentId",method = RequestMethod.GET)
    public String studentId(HttpSession session, Model model){
        logger.info("invoke--------------/student//studentId");
        int studentId = (Integer)session.getAttribute("userId");
        Student student=studentService.queryId(studentId);
        /*查询用户姓名*/
        String studentName=student.getStudentName();
        session.setAttribute("studentName",studentName);

        List<Stuiscou> stuiscous=stuiscouService.queryByStudentId(studentId);
        model.addAttribute("studentInfo",student);
        if (stuiscous!=null&&!stuiscous.isEmpty()){
            model.addAttribute("stuiscuosInfo",stuiscous);
        }
        return "studentInfo";
    }
    @RequestMapping(value = "/update2",method = RequestMethod.GET)
    public String updateteacher2(Student student) {
        logger.info("invoke--------------/student/update");
        studentService.updateStudent(student);
        return "forward:/student/studentId";
    }
    @RequestMapping(value = "/homeTS", method = RequestMethod.GET)
    public String toLogin1() {
        return "homeGood";
    }
    @RequestMapping(value = "/homeStu", method = RequestMethod.GET)
    public String toLogin() {
        return "homeStu";
    }
}

