package com.ejemplo2.ejemplo2.Utility;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class StudentParentPK implements Serializable {

    private static final long serialVersionUID = 1L;


    @Column(name = "student_id")
    private int student_id;


    @Column(name = "parent_id")
    private int parent_id;

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentParentPK that = (StudentParentPK) o;
        return student_id == that.student_id &&
                parent_id == that.parent_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(student_id, parent_id);
    }
}
