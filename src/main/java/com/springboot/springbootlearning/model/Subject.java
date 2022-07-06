package com.springboot.springbootlearning.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "subject")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Subject {

    @Id
    private String id;
    @Field(name = "subject_name")
    private String subjectName;
    @Field(name = "marks_obtained")
    private int marksObtained;

}
