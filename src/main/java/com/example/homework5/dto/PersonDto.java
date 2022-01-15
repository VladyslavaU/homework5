package com.example.homework5.dto;

public class PersonDto {
    private String lastName;
    private Integer phone;

    public PersonDto(final String lastName, final Integer phone){
        this.lastName = lastName;
        this.phone = phone;
    }

    public PersonDto(){

    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Integer getPhone(){
        return this.phone;
    }

    public String getLastName(){
        return this.lastName;
    }

}
