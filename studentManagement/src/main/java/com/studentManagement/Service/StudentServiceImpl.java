package com.studentManagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentManagement.Entity.Student;
import com.studentManagement.Repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student) {
        Student createdStudent = studentRepository.save(student);
        return createdStudent;
       
    }

    @Override
    public Student findById(Long id) {
       Student student = studentRepository.findById(id).get();
       return student;
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
       
    }

    @Override
    public Student updateStudent(Long id, Student student) {

        Student student1 = studentRepository.findById(id).get();
        if(student1!=null){
            student1.setId(student.getId());
            student1.setFirstName(student.getFirstName());
            student1.setLastName(student.getLastName());
            student1.setPassword(student.getPassword());
            student1.setEmail(student.getEmail());
            studentRepository.save(student1);
        
        } 
        return student1;
    }


    @Override
    public List<Student> findAll() {
        List<Student> students = studentRepository.findAll();
        return students;
    }
    
}
