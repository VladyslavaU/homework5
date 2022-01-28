package com.example.homework5.utils.dto;

import lombok.Data;

@Data
public class PersonDto {
    private final String lastName;
    private final Integer phone;

    public PersonDto(final String lastName, final Integer phone){
        this.lastName = lastName;
        this.phone = phone;
    }

    public Integer getPhone(){
        return this.phone;
    }

    public String getLastName(){
        return this.lastName;
    }

}
