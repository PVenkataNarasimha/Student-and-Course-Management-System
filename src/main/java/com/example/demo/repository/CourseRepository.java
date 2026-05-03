package com.example.demo.repository;

import com.example.demo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    
    List<Course> findByInstructorContainingIgnoreCase(String instructor);
    
    @Query("SELECT c FROM Course c WHERE c.credits >= :minCredits")
    List<Course> findCoursesWithMinCredits(int minCredits);
    
    boolean existsByCourseCode(String courseCode);
}
