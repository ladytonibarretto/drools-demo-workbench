package com.drools.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.drools.facts.Course;
import com.drools.facts.SubjectList;
import com.drools.service.CourseService;

@RestController
public class CourseResource {

    private final CourseService courseService;

    @Autowired
    public CourseResource(CourseService courseService){
        this.courseService = courseService;
    }

    @RequestMapping(value = "/suggest",
            method = RequestMethod.POST,
            produces = "application/json")
    public List<Course> getSubjects(@RequestBody SubjectList subjects){
        List<Course> sub = courseService.getSuggestedCourse(subjects.getItems());
        return sub;
    }
}
