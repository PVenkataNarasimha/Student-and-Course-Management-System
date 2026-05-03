package com.example.demo.controller;

import com.example.demo.entity.Course;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseController {
    
    @Autowired
    private CourseService courseService;
    
    @GetMapping
    public String listCourses(Model model) {
        List<Course> courses = courseService.getAllCourses();
        model.addAttribute("courses", courses);
        return "courses/list";
    }
    
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("course", new Course());
        return "courses/add";
    }
    
    @PostMapping("/add")
    public String addCourse(@ModelAttribute Course course, RedirectAttributes redirectAttributes) {
        try {
            courseService.saveCourse(course);
            redirectAttributes.addFlashAttribute("success", "Course added successfully!");
            return "redirect:/courses";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Failed to add course: " + e.getMessage());
            return "redirect:/courses/add";
        }
    }
    
    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        try {
            Course course = courseService.getCourseById(id);
            model.addAttribute("course", course);
            return "courses/update";
        } catch (Exception e) {
            return "redirect:/courses";
        }
    }
    
    @PostMapping("/update/{id}")
    public String updateCourse(@PathVariable Long id, @ModelAttribute Course course,
                               RedirectAttributes redirectAttributes) {
        try {
            courseService.updateCourse(id, course);
            redirectAttributes.addFlashAttribute("success", "Course updated successfully!");
            return "redirect:/courses";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Failed to update: " + e.getMessage());
            return "redirect:/courses/update/" + id;
        }
    }
}
