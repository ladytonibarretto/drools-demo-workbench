package com.drools.facts;

import java.util.List;
import java.util.ArrayList;

public class CourseList {

    private List<Course> items;

    public List<Course> getItems() {
        return items;
    }

    public void setItems(List<Course> items) {
        this.items = items;
    }

    public List<Course> addCourse(String course){
        List<Course> courses = getItems();

        Course courseObj = new Course(course);
        
        if(courses == null){
            courses = new ArrayList<>();
        }
        courses.add(courseObj);

        setItems(courses);

        return courses;
    }
}
