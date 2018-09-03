package com.springboot.restful.service;

import com.springboot.restful.model.Course;
import org.springframework.stereotype.Service;
import java.util.HashMap;

@Service
public class CourseService {

    private HashMap<Integer, Course> courses;

    public CourseService(){
        this.courses = new HashMap<>();
        insertDummyData();
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

    private void insertDummyData(){
        courses.put(1, new Course(1, "Java", "Java Intro"));
        courses.put(2, new Course(2, "Python", "Python Intro"));
        courses.put(3, new Course(3, "Web", "Web Intro"));
        courses.put(4, new Course(4, "Vector Calculus", "Integrating multivariable functions"));
    }
}