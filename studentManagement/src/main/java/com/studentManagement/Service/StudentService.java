package com.studentManagement.Service;

import java.util.List;

import com.studentManagement.Entity.Student;

public interface StudentService {
    
    public Student createStudent(Student student);

    public List<Student> findAll();

    public Student findById(Long id);

    public void deleteById(Long id);

    public Student updateStudent(Long id,Student student);

    
} 
