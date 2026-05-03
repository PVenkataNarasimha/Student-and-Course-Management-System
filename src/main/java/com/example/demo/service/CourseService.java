package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CourseService {
    
    @Autowired
    private CourseRepository courseRepository;
    
    // Create
    public Course saveCourse(Course course) throws Exception {
        if (courseRepository.existsByCourseCode(course.getCourseCode())) {
            throw new Exception("Course code already exists: " + course.getCourseCode());
        }
        return courseRepository.save(course);
    }
    
    // Read - all courses
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
    
    // Read - by ID
    public Course getCourseById(Long id) throws Exception {
        Optional<Course> course = courseRepository.findById(id);
        if (course.isPresent()) {
            return course.get();
        } else {
            throw new Exception("Course not found with id: " + id);
        }
    }
    
    // Update
    public Course updateCourse(Long id, Course updatedCourse) throws Exception {
        Course existingCourse = getCourseById(id);
        existingCourse.setCourseCode(updatedCourse.getCourseCode());
        existingCourse.setCourseName(updatedCourse.getCourseName());
        existingCourse.setCredits(updatedCourse.getCredits());
        existingCourse.setInstructor(updatedCourse.getInstructor());
        return courseRepository.save(existingCourse);
    }
}
