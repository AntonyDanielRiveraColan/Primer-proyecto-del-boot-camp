package com.ejemplo2.ejemplo2.Service.Impl;

import com.ejemplo2.ejemplo2.model.Family_Member;
import com.ejemplo2.ejemplo2.Repository.FamilyMemberRepository;

import com.ejemplo2.ejemplo2.Service.IFamilyMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class Family_Member_Service implements IFamilyMember {

    @Autowired
    FamilyMemberRepository familyMemberRepository;

    /*@Override
    public List<Family_Member> getAllFamilyMembersByFamilyId(int familyId) {
        return familyMemberRepository.getAllFamilyMembersByFamilyID(familyId);
    }*/

    @Override
    public List<Family_Member> getAllFamilyMembers() {
        return familyMemberRepository.findAll();
    }

    @Override
    public void addFamilyMember(Family_Member obj) {
        familyMemberRepository.save(obj);
    }

    @Override
    public void updateFamilyMember(Family_Member obj) {
        familyMemberRepository.save(obj);
    }

    @Override
    public void deleteFamilyMember(Integer id) {
        familyMemberRepository.deleteById(id);
    }
}
