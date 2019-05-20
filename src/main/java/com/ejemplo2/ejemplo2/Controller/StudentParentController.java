package com.ejemplo2.ejemplo2.Controller;

import com.ejemplo2.ejemplo2.model.Student_Parent;
import com.ejemplo2.ejemplo2.Service.IStudentParent;
import com.ejemplo2.ejemplo2.Utility.StudentParentPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sun.applet.Main;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/apistudent-parent/v1")
public class StudentParentController {
    private static Logger LOG = Logger.getLogger(String.valueOf(Main.class));

    @Autowired
    IStudentParent iStudentParent;
    //students/{id}/parents
    //parents/{id}/students
    @GetMapping("/read")
    @ResponseStatus(HttpStatus.OK)
    public List<Student_Parent> getAllStudentParents(){
        LOG.info("com.ejemplo2.ejemplo2.Controller - getAllStudentParents");
        return iStudentParent.getAllStudentParents();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void addStudentParents(@RequestBody Student_Parent obj){
        LOG.info("com.ejemplo2.ejemplo2.Controller - addStudentParents");
        iStudentParent.addStudentParent(obj);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public void updateStudentParents(@RequestBody Student_Parent obj){
        LOG.info("com.ejemplo2.ejemplo2.Controller - updateStudentParents");
        iStudentParent.updateStudentParent(obj);
    }

    @DeleteMapping("/delete/studentid/{studentid}/parentid/{parentid}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudentParents(@PathVariable("studentid") int studentid , @PathVariable("parentid") int parentid){
        LOG.info("com.ejemplo2.ejemplo2.Controller - deleteStudentParents");

       StudentParentPK studentParentPK = new StudentParentPK();
       studentParentPK.setStudent_id(studentid);
       studentParentPK.setParent_id(parentid);

        iStudentParent.deleteStudentParent(studentParentPK);
    }

    @GetMapping("/read/studentid/{studentid}/parentid/{parentid}")
    @ResponseStatus(HttpStatus.OK)
    public Student_Parent getStudentParent(@PathVariable("studentid") int studentid , @PathVariable("parentid") int parentid)
    {
        LOG.info("com.ejemplo2.ejemplo2.Controller - getStudentParent");
        StudentParentPK studentParentPK = new StudentParentPK();
        studentParentPK.setStudent_id(studentid);
        studentParentPK.setParent_id(parentid);
        return iStudentParent.findByStudentIdAndParentId(studentParentPK);
    }
}
