package com.springboot.springbootlearning.model.common;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Address {

    private String streetDetail;
    private String city;
    private String state;
    private String zipCode;
    private String country;


}
