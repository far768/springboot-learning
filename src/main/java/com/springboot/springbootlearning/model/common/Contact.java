package com.springboot.springbootlearning.model.common;


import lombok.*;
import org.springframework.data.mongodb.core.index.CompoundIndex;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Contact {

    private String mobileNumber;
    private String emailId;


}
