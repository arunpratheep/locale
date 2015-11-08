package com.locale.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserData implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    public UserData()
    {
	
    }
    public UserData(String firstName, String lastName, String houseName, String fatherName, String motherName, Long mobile)
    {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.houseName = houseName;
	this.fatherName = fatherName;
	this.motherName = motherName;
	this.mobile = mobile;
    }

    private String firstName;
    private String lastName;
    private String houseName;
    private String fatherName;
    private String motherName;
    private Long mobile;

    public Long getId()
    {
	return id;
    }

    public void setId(Long id)
    {
	this.id = id;
    }

    public String getFirstName()
    {
	return firstName;
    }

    public void setFirstName(String firstName)
    {
	this.firstName = firstName;
    }

    public String getLastName()
    {
	return lastName;
    }

    public void setLastName(String lastName)
    {
	this.lastName = lastName;
    }

    public String getHouseName()
    {
	return houseName;
    }

    public void setHouseName(String houseName)
    {
	this.houseName = houseName;
    }

    public String getFatherName()
    {
	return fatherName;
    }

    public void setFatherName(String fatherName)
    {
	this.fatherName = fatherName;
    }

    public String getMotherName()
    {
	return motherName;
    }

    public void setMotherName(String motherName)
    {
	this.motherName = motherName;
    }

    public Long getMobile()
    {
	return mobile;
    }

    public void setMobile(Long mobile)
    {
	this.mobile = mobile;
    }

}
