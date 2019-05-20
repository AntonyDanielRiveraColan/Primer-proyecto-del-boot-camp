package com.ejemplo2.ejemplo2.Service;

import com.ejemplo2.ejemplo2.model.Student;


import java.util.List;

public interface IStudent {

    public List<Student> getAllStudents();
    public void addStudent(Student obj);
    public void updateStudent(Student obj);
    public void deleteStudent(Integer id);
    public List<Student> getAllStudentsXIdClass(Integer idClass);
    public Student findByStudentId(Integer id);
}
