package com.example.liangl.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Spitter {

    @NotNull
    @Size(min = 2,max = 30)
    private String firstname;

    @NotNull
    @Size(min = 2,max = 30)
    private String lastname;

    @NotNull
    @Size(min = 2,max = 16)
    private String username;

    @NotNull
    @Size(min = 2,max = 25)
    private String password;
    private Long index;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getIndex() {
        return index;
    }

    public void setIndex(Long index) {
        this.index = index;
    }

    public Spitter(){}

    public Spitter(String firstname, String lastname, String username, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
    }

    public Spitter(Long index, String firstname, String lastname, String username, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.index = index;
    }
    @Override
    public boolean equals(Object that){
        return EqualsBuilder.reflectionEquals(this, that, "id", "time");
    }
    @Override
    public int hashCode(){
        return HashCodeBuilder.reflectionHashCode(this, "id", "time");
    }

}
