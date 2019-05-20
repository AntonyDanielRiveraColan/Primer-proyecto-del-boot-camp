package com.ejemplo2.ejemplo2.Controller;

import com.ejemplo2.ejemplo2.model.Student;
import com.ejemplo2.ejemplo2.Service.IStudent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sun.applet.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("apistudent/v1")
public class StudentController {
    private static Logger LOG = Logger.getLogger(String.valueOf(Main.class));

    @Autowired
    private IStudent studentDAO;

    @GetMapping("/read")
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getAllStudents(){
        LOG.info("com.ejemplo2.ejemplo2.Controller - getAllStudents");
        return studentDAO.getAllStudents();
    }


    @GetMapping("/listStudenXIdClass/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getlistStudentXIdClass(@PathVariable("id") Integer idClass){
        LOG.info("com.ejemplo2.ejemplo2.Controller - getlistStudentXIdClass");
        return studentDAO.getAllStudentsXIdClass(idClass);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void addStudent(@RequestBody Student obj){
        LOG.info("com.ejemplo2.ejemplo2.Controller - addStudent");
        studentDAO.addStudent(obj);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public void updateStudent(@RequestBody Student obj){
        LOG.info("com.ejemplo2.ejemplo2.Controller - updateStudent");
        studentDAO.updateStudent(obj);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudent(@PathVariable("id") Integer id){
        LOG.info("com.ejemplo2.ejemplo2.Controller - deleteStudent");
        studentDAO.deleteStudent(id);
    }

    @GetMapping("/listId/{ids}")
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getAllIds(@PathVariable String ids){
        LOG.info("com.ejemplo2.ejemplo2.Controller - getAllIds");
        String [] list = ids.split("");
        for (int i = 0 ; i<list.length; i++){

        }


        return studentDAO.getAllStudents();
    }

}
