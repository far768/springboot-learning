package com.springboot.springbootlearning.repository;

import com.springboot.springbootlearning.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    void deleteByFirstName(String firstName);

    void deleteByLastName(String lastName);

    void deleteByLastNameAndFirstName(String lastName, String firstName);

    void deleteByAge(int age);

    void deleteByContactMobileNumberOrContactEmailId(String mobileNumber, String emailId);

    Page<User> findAll(Pageable pageable);

    @Query(value = "{ 'firstName' : ?0 }", fields = "{ 'firstName' : 1, 'lastname' : 1}")
    List<User> findByFirstName(String firstName);

    List<User> findByLastName(String lastName);

    List<User> findByLastNameAndFirstName(String lastName, String firstName);

    List<User> findByAge(int age);

    List<User> findByContactMobileNumberOrContactEmailId(String mobileNumber, String emailId);

//    Optional<User> updateById(User user);

//    List<User> updateByFirstName(String firstName, User user);

//    List<User> updateByLastName(String lastName, User user);

//    List<User> updateByLastNameAndFirstName(String lastName, String firstName, User user);

//    List<User> updateByAge(int age, User user);

//    List<User> updateByContactMobileNumberOrContactEmailId(String mobileNumber, String emailId, User user);

//    List<User> updateFirstNameLastNameById(String id, String firstName, String lastName);

    @Query("{ 'age' : ?0 }")
    @Update("{ '$inc' : { 'age' : ?1 } }")
    void updateAllAgeByAge(int age, int incrementBy);

    @Query("{ 'lastName' : ?0 }")
    @Update("{ '$set' : { 'address.country' : ?1 } }")
    void updateAllCountryBylastName(String lastName, String country);

    @Aggregation("{ '$project': { '_id' : '$lastName' } }")
    List<String> findAllLastnames();

}
