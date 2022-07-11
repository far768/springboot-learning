package com.springboot.springbootlearning.model.common;


import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;

@Data
public class Contact {

    @Indexed(unique = true)
    private String mobileNumber;
    @Indexed(unique = true)
    private String emailId;


}
