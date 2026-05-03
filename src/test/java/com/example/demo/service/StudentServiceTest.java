package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    private Student testStudent;

    @BeforeEach
    void setUp() {
        testStudent = new Student("John", "Doe", "john.doe@test.com", 2023);
        testStudent.setId(1L);
    }

    @Test
    void testSaveStudent_Success() throws Exception {
        when(studentRepository.existsByEmail(anyString())).thenReturn(false);
        when(studentRepository.save(any(Student.class))).thenReturn(testStudent);

        Student saved = studentService.saveStudent(testStudent);

        assertNotNull(saved);
        assertEquals("John", saved.getFirstName());
        verify(studentRepository, times(1)).save(any(Student.class));
    }

    @Test
    void testSaveStudent_DuplicateEmail_ThrowsException() {
        when(studentRepository.existsByEmail(anyString())).thenReturn(true);

        Exception exception = assertThrows(Exception.class, () -> {
            studentService.saveStudent(testStudent);
        });

        assertTrue(exception.getMessage().contains("Email already exists"));
        verify(studentRepository, never()).save(any(Student.class));
    }

    @Test
    void testGetAllStudents() {
        List<Student> students = Arrays.asList(testStudent, new Student("Jane", "Smith", "jane@test.com", 2022));
        when(studentRepository.findAll()).thenReturn(students);

        List<Student> result = studentService.getAllStudents();

        assertEquals(2, result.size());
        verify(studentRepository, times(1)).findAll();
    }

    @Test
    void testGetStudentById_Success() throws Exception {
        when(studentRepository.findById(1L)).thenReturn(Optional.of(testStudent));

        Student found = studentService.getStudentById(1L);

        assertNotNull(found);
        assertEquals("John", found.getFirstName());
    }

    @Test
    void testGetStudentById_NotFound_ThrowsException() {
        when(studentRepository.findById(99L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(Exception.class, () -> {
            studentService.getStudentById(99L);
        });

        assertTrue(exception.getMessage().contains("Student not found"));
    }

    @Test
    void testUpdateStudent_Success() throws Exception {
        Student updatedDetails = new Student("Johnny", "Doe", "johnny.doe@test.com", 2024);
        
        when(studentRepository.findById(1L)).thenReturn(Optional.of(testStudent));
        when(studentRepository.save(any(Student.class))).thenReturn(updatedDetails);

        Student updated = studentService.updateStudent(1L, updatedDetails);

        assertEquals("Johnny", updated.getFirstName());
        assertEquals(2024, updated.getEnrollmentYear());
    }
}
