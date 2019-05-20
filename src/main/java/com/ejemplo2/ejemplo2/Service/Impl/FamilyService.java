package com.ejemplo2.ejemplo2.Service.Impl;

import com.ejemplo2.ejemplo2.model.Family;
import com.ejemplo2.ejemplo2.Repository.FamilyRepository;
import com.ejemplo2.ejemplo2.Service.IFamily;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamilyService implements IFamily {

    @Autowired
    FamilyRepository familyRepository;


    @Override
    public List<Family> getAllFamilies() {
        return familyRepository.findAll();
    }

    @Override
    public void addFamily(Family obj) {
        familyRepository.save(obj);
    }

    @Override
    public void udpdateFamily(Family obj) {
        familyRepository.save(obj);
    }

    @Override
    public void deleteFamily(Integer id) {
        familyRepository.deleteById(id);
    }

    @Override
    public Family findByFamilyId(Integer id) {return familyRepository.findById(id).get();}


}
