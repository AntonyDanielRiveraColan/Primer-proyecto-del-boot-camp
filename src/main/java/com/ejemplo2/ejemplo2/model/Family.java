package com.ejemplo2.ejemplo2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "families")
public class Family {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "family_id")
  private int id;

  @ManyToOne
  @JoinColumn(name = "head_of_family_parent_id")
  private Parent parent;

  @Column(name = "family_name")
  private String familyName;



  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Parent getParent() {
    return parent;
  }

  public void setParent(Parent parent) {
    this.parent = parent;
  }

  public String getFamilyName() {
    return familyName;
  }

  public void setFamilyName(String familyName) {
    this.familyName = familyName;
  }

}
