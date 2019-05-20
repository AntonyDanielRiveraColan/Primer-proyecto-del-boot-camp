package com.ejemplo2.ejemplo2.Repository;

import com.ejemplo2.ejemplo2.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    @Query(value = "select s.* from students as s \n" +
            "inner join student_classes as sc on sc.student_id= s.student_id\n" +
            "where sc.class_id=(:idClas)", nativeQuery = true)
    List<Student> listStudentXIdClass(@Param("idClas") Integer idClas);
}
