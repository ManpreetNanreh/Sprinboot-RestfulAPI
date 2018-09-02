package com.springboot.restful.service;

import com.springboot.restful.model.Course;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CourseService {

    private HashMap<Integer, Course> courses;

    public CourseService(){
        this.courses = new HashMap<Integer, Course>();
    }

    public HashMap<Integer, Course> getAll(){
        return courses;
    }

    public Course getCourse(int id){
        return courses.get(id);
    }

    public void addCourse(Course c){
        courses.put(c.getId(), c);
    }

    public void updateCourse(Course c){
        if(courses.containsKey(c.getId())){
            courses.put(c.getId(), c);
        }
    }

    public void deleteCourse(int id){
        courses.remove(id);
    }
}