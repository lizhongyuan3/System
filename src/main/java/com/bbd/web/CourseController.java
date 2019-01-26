package com.bbd.web;


import com.bbd.entity.Course;
import com.bbd.service.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/course")
public class CourseController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private CourseService courseService;
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(Model model, Integer offset, Integer limit){
        logger.info("invoke----------/course/list");
        offset = offset == null ? 0 : offset;//默认便宜0
        limit = limit == null ? 50 : limit;//默认展示50条
        List<Course> list = courseService.queryCourse(offset, limit);
        model.addAttribute("courselist", list);
        return "course";
    }
}