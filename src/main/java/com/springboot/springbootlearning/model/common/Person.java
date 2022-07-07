package com.springboot.springbootlearning.model.common;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@CompoundIndex(name = "lname_fname", def = "{'lastName': 1, 'firstName': 1}")
public class Person {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    @Indexed
    private int age;
    @CreatedDate
    private LocalDateTime createdOn;
    @LastModifiedDate
    private LocalDateTime modifiedOn;

    private Contact contact;
    private Address address;

}
