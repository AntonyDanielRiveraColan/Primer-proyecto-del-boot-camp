package com.ejemplo2.ejemplo2.Service;

import com.ejemplo2.ejemplo2.model.Family;

import java.util.List;

public interface IFamily {

    public List<Family> getAllFamilies();
    public void addFamily(Family obj);
    public void udpdateFamily(Family obj);
    public void deleteFamily(Integer id);
    public Family findByFamilyId(Integer id);
}
