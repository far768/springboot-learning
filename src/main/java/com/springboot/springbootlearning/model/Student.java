package com.springboot.springbootlearning.model;

import java.util.Date;
import java.util.List;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "student")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Student {

    @Id
    private String id;

    private String name;

    @Field(name = "mail")
    private String email;

    @DBRef
    private Department department;

    @DBRef
    private List<Subject> subjects;

    Date createdOn = new Date();
    Date modifiedOn = new Date();
    @Transient
    private double percentage;

    public double getPercentage() {
        if (subjects != null && subjects.size() > 0) {
            int total = 0;
            for (Subject subject : subjects) {
                total += subject.getMarksObtained();
            }
            return total / subjects.size();
        }
        return 0.00;
    }

}
