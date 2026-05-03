package com.example.demo.repository;

import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    
    // Custom query method
    List<Student> findByLastNameContainingIgnoreCase(String lastName);
    
    List<Student> findByEnrollmentYear(Integer year);
    
    // Custom JPQL query with JOIN
    @Query("SELECT s FROM Student s JOIN s.courses c WHERE c.courseCode = :courseCode")
    List<Student> findStudentsEnrolledInCourse(@Param("courseCode") String courseCode);
    
    // Inner join returning custom result
    @Query("SELECT s.firstName, s.lastName, c.courseName FROM Student s JOIN s.courses c")
    List<Object[]> getStudentCourseJoinResult();
    
    boolean existsByEmail(String email);
}
