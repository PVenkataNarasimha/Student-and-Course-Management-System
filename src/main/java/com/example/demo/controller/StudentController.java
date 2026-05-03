package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    
    @Autowired
    private StudentService studentService;
    
    // READ - List all students
    @GetMapping
    public String listStudents(Model model) {
        try {
            List<Student> students = studentService.getAllStudents();
            model.addAttribute("students", students);
            
            // Custom join query result
            List<Object[]> joinResult = studentService.getStudentCourseJoinResult();
            model.addAttribute("joinResult", joinResult);
            
            return "students/list";
        } catch (Exception e) {
            model.addAttribute("error", "Error fetching students: " + e.getMessage());
            return "error";
        }
    }
    
    // CREATE - Show form
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("student", new Student());
        return "students/add";
    }
    
    // CREATE - Save student
    @PostMapping("/add")
    public String addStudent(@ModelAttribute Student student, RedirectAttributes redirectAttributes) {
        try {
            studentService.saveStudent(student);
            redirectAttributes.addFlashAttribute("success", "Student added successfully!");
            return "redirect:/students";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Failed to add student: " + e.getMessage());
            return "redirect:/students/add";
        }
    }
    
    // UPDATE - Show update form
    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        try {
            Student student = studentService.getStudentById(id);
            model.addAttribute("student", student);
            return "students/update";
        } catch (Exception e) {
            model.addAttribute("error", "Student not found");
            return "redirect:/students";
        }
    }
    
    // UPDATE - Save updated student
    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute Student student, 
                                RedirectAttributes redirectAttributes) {
        try {
            studentService.updateStudent(id, student);
            redirectAttributes.addFlashAttribute("success", "Student updated successfully!");
            return "redirect:/students";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Failed to update: " + e.getMessage());
            return "redirect:/students/update/" + id;
        }
    }
}
