package com.SpringMan.MongoDB.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.SpringMan.MongoDB.Entity.Student;
import com.SpringMan.MongoDB.Repo.StudentRepo;

@Service
public class StudentService {
    private final StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo){
        this.studentRepo = studentRepo;
    }

    public List<Student> getAllStudents(){
        return studentRepo.findAll();
    }

    public Student saveStudent(Student student){
        return studentRepo.save(student);
    }

    public Student getStudentById(String id){
        return studentRepo.findById(id).orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }

    public void deleteStudent(String id){
        studentRepo.deleteById(id);
    }
}
