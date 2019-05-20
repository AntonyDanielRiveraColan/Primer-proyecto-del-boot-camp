package com.ejemplo2.ejemplo2.Repository;

import com.ejemplo2.ejemplo2.model.Student_Parent;
import com.ejemplo2.ejemplo2.Utility.StudentParentPK;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentParentRepository extends JpaRepository<Student_Parent, StudentParentPK> {

}
