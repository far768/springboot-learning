package com.springboot.springbootlearning.model.common;


import lombok.*;
import org.springframework.data.mongodb.core.index.CompoundIndex;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@CompoundIndex(name = "mobilenumber_emailid", def = "{'mobileNumber': 1, 'emailId': 1}")
public class Contact {

    private String mobileNumber;
    private String emailId;


}
