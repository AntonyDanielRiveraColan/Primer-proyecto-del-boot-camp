package com.ejemplo2.ejemplo2.model;

import com.ejemplo2.ejemplo2.Utility.StudentParentPK;


import javax.persistence.*;

@Entity
@Table(name = "student_parents")
public class Student_Parent{

    @EmbeddedId
    protected StudentParentPK studentParentPK;


    @ManyToOne
    @MapsId("student_id")
    @JoinColumn(name = "student_id")
    private Student student = new Student();


    @ManyToOne
    @MapsId("parent_id")
    @JoinColumn(name = "parent_id")
    private Parent parent = new Parent();

    public StudentParentPK getStudentParentPK() {
        return studentParentPK;
    }

    public void setStudentParentPK(StudentParentPK studentParentPK) {
        this.studentParentPK = studentParentPK;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }


    private static final long serialVersionUID = 1L;
}
