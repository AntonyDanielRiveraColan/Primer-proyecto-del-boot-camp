package com.ejemplo2.ejemplo2.Service;

import com.ejemplo2.ejemplo2.model.Family_Member;

import java.util.List;


public interface IFamilyMember {

    public List<Family_Member> getAllFamilyMembers();
    public void addFamilyMember(Family_Member obj);
    public void updateFamilyMember(Family_Member obj);
    public void deleteFamilyMember(Integer id);

   /* public List<Family_Member> getAllFamilyMembersByFamilyId(int familyId);*/
}
