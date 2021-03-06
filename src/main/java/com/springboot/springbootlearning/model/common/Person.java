package com.springboot.springbootlearning.model.common;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;

import java.time.LocalDateTime;


@Data
public class Person {

    @Id
    private String id;
    @Indexed
    private String firstName;
    @Indexed
    private String lastName;
    private int age;
    @CreatedDate
    private LocalDateTime createdOn;
    @LastModifiedDate
    private LocalDateTime modifiedOn;
    private boolean active;
    private Contact contact;
    private Address address;

    private Role role;

}
