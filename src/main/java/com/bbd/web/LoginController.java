package com.bbd.web;

import com.bbd.entity.Student;
import com.bbd.entity.Teacher;
import com.bbd.entity.User;
import com.bbd.service.LoginService;
import com.bbd.service.StudentService;
import com.bbd.service.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private LoginService loginService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String toLogin() {
        return "../../index";
    }

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public String dologin(User user, Model model,HttpSession session) {
        logger.info("invoke------------login");
        User user1 = loginService.queryUser(user);
        if (user1 != null) {
            session.setAttribute("user_session",user1);
            int userId = user1.getUserId();
            session.setAttribute("userId",userId);
            if (user.getUserId() < 10000 && user.getUserId() > 1000) {
                return "homeTea";
            } else if (user.getUserId() > 15011100 && user.getUserId() < 15144400) {
                return "homeStu";
            }
            else if(user.getUserId()==123){
                return "home";
            }
            else{
                return "../../index";
            }
        }
        else {
            return "../../index";
        }
    }

    //退出登录
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest request){
        logger.info("invoke------------logout");
        request.getSession().invalidate();
        return "../../index";
    }

    @RequestMapping(value = "/ref",method = RequestMethod.POST)
    public String refLogin(User user,Model model) {
        logger.info("invoke--------------/refLogin");
        User user1=user;
        if(user1!=null){
            Student student =studentService.queryId(user.getUserId());
            Teacher teacher=teacherService.queryId(user.getUserId());
            if(student!=null||teacher!=null){
                loginService.insertUser(user);
                return "../../index";}
            else{
                model.addAttribute("msg","该用户不能注册，非本校");
                return "../../reg";
            }
        }
            model.addAttribute("msg","不能为空");
            return "../../reg";

    }
    @RequestMapping(value = "/ref2", method = RequestMethod.GET)
    public String toLogin2() {
        return "../../reg";
    }
    @RequestMapping(value = "/homeLogin", method = RequestMethod.GET)
    public String toLogin3() {
        return "home";
    }

}