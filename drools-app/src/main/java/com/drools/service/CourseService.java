package com.drools.service;

import java.util.List;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drools.facts.Course;
import com.drools.facts.CourseList;
import com.drools.facts.Subject;

@Service
public class CourseService {
 
    private KieContainer kieContainer;
 
    @Autowired
    public CourseService(KieContainer kieContainer){
        this.kieContainer = kieContainer;
    }

    public List<Course> getSuggestedCourse(List<Subject> subjects) {
    	final CourseList courses = new CourseList();
    	StatelessKieSession statelessKieSession = kieContainer.newStatelessKieSession();
    	statelessKieSession.setGlobal("courses", courses);
    	statelessKieSession.execute(subjects);

        return courses.getItems();
    }


}
