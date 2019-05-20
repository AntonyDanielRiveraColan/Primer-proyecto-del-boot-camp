package com.ejemplo2.ejemplo2.Service.Impl;

import com.ejemplo2.ejemplo2.model.Parent;
import com.ejemplo2.ejemplo2.Repository.ParentRepository;
import com.ejemplo2.ejemplo2.Service.IParent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentService implements IParent {

    @Autowired
    private ParentRepository parentRepository;

    @Override
    public List<Parent> getAllParents(){
        return parentRepository.findAll();
    }

    @Override
    public void addParent(Parent obj){
        parentRepository.save(obj);
    }

    @Override
    public void updateParent(Parent obj){
        parentRepository.save(obj);
    }

    @Override
    public void deleteParent(Integer id){
        parentRepository.deleteById(id);
    }
}
