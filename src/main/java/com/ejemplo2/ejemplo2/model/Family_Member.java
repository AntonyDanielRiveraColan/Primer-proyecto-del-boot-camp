package com.ejemplo2.ejemplo2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@Table(name = "family_members")
public class Family_Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    @ManyToOne
    @JoinColumn(name = "family_id")
    private Family family;

    @Column(name = "parent_or_student_member")
    private String parentOrStudentMember;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Parent parent;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public String getParentOrStudentMember() {
        return parentOrStudentMember;
    }

    public void setParentOrStudentMember(String parentOrStudentMember) {
        this.parentOrStudentMember = parentOrStudentMember;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
