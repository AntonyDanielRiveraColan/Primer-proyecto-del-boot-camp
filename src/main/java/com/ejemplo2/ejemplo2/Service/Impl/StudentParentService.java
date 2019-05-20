package com.ejemplo2.ejemplo2.Service.Impl;

import com.ejemplo2.ejemplo2.model.Student_Parent;
import com.ejemplo2.ejemplo2.Repository.StudentParentRepository;
import com.ejemplo2.ejemplo2.Service.IStudentParent;
import com.ejemplo2.ejemplo2.Utility.StudentParentPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentParentService implements IStudentParent {

    @Autowired
    StudentParentRepository studentParentRepository;

    @Override
    public List<Student_Parent> getAllStudentParents() {
        return studentParentRepository.findAll();
    }

    @Override
    public void addStudentParent(Student_Parent obj) {

        studentParentRepository.save(obj);
    }

    @Override
    public Student_Parent findByStudentIdAndParentId(StudentParentPK obj) {
        return studentParentRepository.findById(obj).get();
    }

    @Override
    public void updateStudentParent(Student_Parent obj) {
        studentParentRepository.save(obj);
    }

    @Override
    public void deleteStudentParent(StudentParentPK obj) {
        studentParentRepository.deleteById(obj);;
    }
}
