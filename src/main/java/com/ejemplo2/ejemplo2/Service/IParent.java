package com.ejemplo2.ejemplo2.Service;

import com.ejemplo2.ejemplo2.model.Parent;

import java.util.List;

public interface IParent {

    public List<Parent> getAllParents();
    public void addParent(Parent obj);
    public void updateParent(Parent obj);
    public void deleteParent(Integer id);

}
