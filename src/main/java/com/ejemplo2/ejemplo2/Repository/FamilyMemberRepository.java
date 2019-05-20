package com.ejemplo2.ejemplo2.Repository;

import com.ejemplo2.ejemplo2.model.Family_Member;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface FamilyMemberRepository extends JpaRepository<Family_Member,Integer> {

    /*@Query("select x from Family_Member x where Family.id=?1")
    public List<Family_Member> getAllFamilyMembersByFamilyID(int familyid);*/
}
