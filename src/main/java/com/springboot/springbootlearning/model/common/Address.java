package com.springboot.springbootlearning.model.common;


import lombok.Data;

@Data
public class Address {

    private String type;
    private String streetDetail;
    private String city;
    private String state;
    private String zipCode;
    private String country;

}

