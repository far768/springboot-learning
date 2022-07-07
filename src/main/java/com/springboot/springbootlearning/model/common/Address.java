package com.springboot.springbootlearning.model.common;


import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class Address {

    private String streetDetail;
    private String city;
    private String state;
    private String zipCode;
    private String country;


}
