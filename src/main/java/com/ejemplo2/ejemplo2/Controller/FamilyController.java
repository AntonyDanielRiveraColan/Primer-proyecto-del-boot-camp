package com.ejemplo2.ejemplo2.Controller;

import com.ejemplo2.ejemplo2.model.Family;
import com.ejemplo2.ejemplo2.Service.IFamily;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sun.applet.Main;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/apifamily/v1")
public class FamilyController {
    private static Logger LOG = Logger.getLogger(String.valueOf(Main.class));

    @Autowired
    IFamily iFamily;

    @GetMapping("/read")
    @ResponseStatus(HttpStatus.OK)
    public List<Family> getAllFamilies(){
        LOG.info("com.ejemplo2.ejemplo2.Controller - getAllFamilies ");
        return iFamily.getAllFamilies();
    }

    @GetMapping("/read/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Family findByFamilyId(@PathVariable("id") Integer id) {
        LOG.info("com.ejemplo2.ejemplo2.Controller - findByFamilyId ");
        return iFamily.findByFamilyId(id);}

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void addFamily(@RequestBody Family obj){
        LOG.info("com.ejemplo2.ejemplo2.Controller - addFamily ");
        iFamily.addFamily(obj);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public void updateFamily(@RequestBody Family obj){
        LOG.info("com.ejemplo2.ejemplo2.Controller - updateFamily ");
        iFamily.udpdateFamily(obj);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteFamily(@PathVariable("id") Integer id ){
        LOG.info("com.ejemplo2.ejemplo2.Controller - deleteFamily ");
        iFamily.deleteFamily(id);
    }

}
