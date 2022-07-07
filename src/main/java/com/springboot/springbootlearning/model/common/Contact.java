package com.springboot.springbootlearning.model.common;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Contact {

    private String mobileNumber;
    private String emailId;


}
