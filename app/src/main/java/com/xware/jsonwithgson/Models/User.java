package com.xware.jsonwithgson.Models;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable
{
    private int id;
    private String name;
    private Date dateOfBirth;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }
}
