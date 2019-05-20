package com.ejemplo2.ejemplo2.Service.Impl;

import com.ejemplo2.ejemplo2.model.Student;
import com.ejemplo2.ejemplo2.Repository.StudentRepository;
import com.ejemplo2.ejemplo2.Service.IStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudent {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }



    @Override
    public void addStudent(Student obj) {
         studentRepository.save(obj);
    }

    @Override
    public void updateStudent(Student obj) {
        studentRepository.save(obj);
    }

    @Override
    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> getAllStudentsXIdClass(Integer idClass) {
        return  studentRepository.listStudentXIdClass(idClass);
    }

    @Override
    public Student findByStudentId(Integer id) {
        return studentRepository.findById(id).get();
    }
}
