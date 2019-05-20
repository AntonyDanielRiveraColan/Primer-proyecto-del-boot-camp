package com.ejemplo2.ejemplo2.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@ApiModel(description = "Informacion del Parent")
@Entity
@Table(name="parents")
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="parent_id")
    private int id;

    //@NotNull(message="El genero es obligatorio")
    @ApiModelProperty(notes = "El genero debe de tener minimo un caracter")
    private String gender;

    @Column(name="first_name")
    //@NotNull(message="El primer nombre es obligatorio")
    private String firstName;

    @Column(name="middle_name")
    //@NotEmpty(message="El segundo nombre es obligatorio")
    private String middleName;

    @Column(name="last_name")
   // @NotEmpty(message="El apellido es obligatorio")
    private String lastName;

    @Column(name="other_parent_detail")
    private String otherParentDetails;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getOtherParentDetails() {
        return otherParentDetails;
    }

    public void setOtherParentDetails(String otherParentDetails) {
        this.otherParentDetails = otherParentDetails;
    }
}
