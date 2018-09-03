package com.springboot.restful.controller;

import com.springboot.restful.model.Course;
import com.springboot.restful.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;

@RestController
public class CourseController implements ErrorController {

    @Autowired
    private CourseService cs;

    private static final String ERRORPATH = "/error";

    @GetMapping("/courses")
    public HashMap<Integer, Course> getAllCourses(){
        return cs.getAll();
    }

    @GetMapping("/courses/{id}")
    public Course getCourse(@PathVariable("id") int id){
        return cs.getCourse(id);
    }

    @PostMapping("/courses")
    public void addCourse(@RequestBody Course c){
        cs.addCourse(c);
    }

    @PutMapping("/courses")
    public void updateCourse(@RequestBody Course c){
        cs.updateCourse(c);
    }

    @DeleteMapping("/courses/{id}")
    public void deleteCourse(@PathVariable("id") int id){
        cs.deleteCourse(id);
    }

    @RequestMapping(value = ERRORPATH)
    public String error(){
        return "Invalid Page!!";
    }

    @Override
    public String getErrorPath(){
        return ERRORPATH;
    }
}