package com.ejemplo2.ejemplo2.Service;

import com.ejemplo2.ejemplo2.model.Student_Parent;
import com.ejemplo2.ejemplo2.Utility.StudentParentPK;


import java.util.List;

public interface IStudentParent {

    public List<Student_Parent> getAllStudentParents();
    public void addStudentParent(Student_Parent obj);
    public void updateStudentParent(Student_Parent obj);
    public void deleteStudentParent(StudentParentPK obj);

    public Student_Parent findByStudentIdAndParentId(StudentParentPK obj);
}
