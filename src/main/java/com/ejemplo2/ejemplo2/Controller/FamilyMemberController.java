package com.ejemplo2.ejemplo2.Controller;

import com.ejemplo2.ejemplo2.model.Family_Member;
import com.ejemplo2.ejemplo2.Service.IFamilyMember;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sun.applet.Main;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/apifamily-member/v1")
public class FamilyMemberController {

    private static Logger LOG = Logger.getLogger(String.valueOf(Main.class));

    @Autowired
    private IFamilyMember iFamilyMember;

    @GetMapping("/read")
    @ResponseStatus(HttpStatus.OK)
    public List<Family_Member> getAllFamiliMembers(){
        LOG.info("com.ejemplo2.ejemplo2.Controller - getAllFamiliMembers");
        return iFamilyMember.getAllFamilyMembers();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void addFamilyMember(@RequestBody Family_Member obj){
        LOG.info("com.ejemplo2.ejemplo2.Controller - addFamilyMember");
        iFamilyMember.addFamilyMember(obj);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public void updateFamilyMember(@RequestBody Family_Member obj){
        LOG.info("com.ejemplo2.ejemplo2.Controller - updateFamilyMember");
        iFamilyMember.updateFamilyMember(obj);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteFamilyMember(@PathVariable ("id") Integer id){
        LOG.info("com.ejemplo2.ejemplo2.Controller - deleteFamilyMember");
        iFamilyMember.deleteFamilyMember(id);
    }
}
