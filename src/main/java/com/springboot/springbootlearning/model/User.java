package com.springboot.springbootlearning.model;


import com.springboot.springbootlearning.model.common.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User extends Person {
    int versionId;
}
