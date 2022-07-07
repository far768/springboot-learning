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
/*
The order of the indexed fields has a strong impact on the effectiveness of a particular
index for a given query. For most compound indexes,
following the ESR (Equality, Sort, Range) rule helps to create efficient indexes.
 */
@CompoundIndexes({
        @CompoundIndex(def = "{'lastName': 1, 'address.city': 1, 'age': 1}", name = "esr-compound-idx")
})
public class User extends Person {
    int versionId;
}
