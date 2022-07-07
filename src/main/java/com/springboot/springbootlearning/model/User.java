package com.springboot.springbootlearning.model;


import com.springboot.springbootlearning.model.common.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@CompoundIndexes({
        @CompoundIndex(def = "{'lastName':1, 'firstName':1}", name = "compound_index_1"),
        @CompoundIndex(def = "{'contact.mobileNumber':1, 'contact.email':1}", name = "compound_index_2")
})
public class User extends Person {
    int versionId;
}
