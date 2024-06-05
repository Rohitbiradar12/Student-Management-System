package com.studentManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.studentManagement.Entity.Student;
import com.studentManagement.Repository.StudentRepository;
import com.studentManagement.Service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/all")
    public String getAllStudents(Model model){
        model.addAttribute("students", studentService.findAll());
        return "views/students";
    }

    @GetMapping("/new")
    public String addStudent(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "views/createStudentForm";
    }

    @PostMapping("/add")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.createStudent(student);
        return "redirect:/students/all";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudent(@PathVariable Long id,Model model){
        model.addAttribute("students", studentService.findById(id));
        return "views/updateStudent";
    }

    @PostMapping("students/{id}")
    public String updateStudent(@PathVariable Long id,@ModelAttribute("student") Student student,Model model){
        Student existingStudent = studentRepository.findById(id).get();
        if(existingStudent!=null){
            studentService.updateStudent(id, existingStudent);
        }
        return "redirect:/students/all";
    }
}
