package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentService {
    
    @Autowired
    private StudentRepository studentRepository;
    
    // Create
    public Student saveStudent(Student student) throws Exception {
        if (studentRepository.existsByEmail(student.getEmail())) {
            throw new Exception("Email already exists: " + student.getEmail());
        }
        return studentRepository.save(student);
    }
    
    // Read - all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    
    // Read - by ID
    public Student getStudentById(Long id) throws Exception {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            return student.get();
        } else {
            throw new Exception("Student not found with id: " + id);
        }
    }
    
    // Read - custom query with join
    public List<Object[]> getStudentCourseJoinResult() {
        return studentRepository.getStudentCourseJoinResult();
    }
    
    // Read - students by course code
    public List<Student> getStudentsByCourseCode(String courseCode) {
        return studentRepository.findStudentsEnrolledInCourse(courseCode);
    }
    
    // Update
    public Student updateStudent(Long id, Student updatedStudent) throws Exception {
        Student existingStudent = getStudentById(id);
        existingStudent.setFirstName(updatedStudent.getFirstName());
        existingStudent.setLastName(updatedStudent.getLastName());
        existingStudent.setEmail(updatedStudent.getEmail());
        existingStudent.setEnrollmentYear(updatedStudent.getEnrollmentYear());
        return studentRepository.save(existingStudent);
    }
    
    // Delete (optional - not required but good to have)
    public void deleteStudent(Long id) throws Exception {
        Student student = getStudentById(id);
        studentRepository.delete(student);
    }
}
