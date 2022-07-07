package com.springboot.springbootlearning.model.common;


import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Address {

    private String streetDetail;
    @Indexed
    private String city;
    private String state;
    private String zipCode;
    @Indexed
    private String country;


}
