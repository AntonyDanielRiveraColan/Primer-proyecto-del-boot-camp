package com.ejemplo2.ejemplo2.Repository;

import com.ejemplo2.ejemplo2.model.Parent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentRepository extends JpaRepository<Parent,Integer> {
}
