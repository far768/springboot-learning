package com.springboot.springbootlearning.repository;

import com.springboot.springbootlearning.model.User;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    List<User> findByRoleTitleRegex(String titleRegex);

    @Query(fields = "{ 'firstName' : 1, 'lastName' : 1}")
    List<User> findByRoleTitleIgnoreCase(String firstName);

    List<User> findByFirstNameIsLike(String regexp);

    List<User> findByActiveIsTrue();

    List<User> findByActiveIsFalse();

    List<User> findByLastNameAndFirstNameOrContactMobileNumber(String lastName, String firstName, String mobileNumber);

    List<User> findByAgeBetween(int from, int to);


    @Query("{ 'age' : { $gt: ?0, $lt: ?1 } }")
    @Update("{ '$addToSet' : {'firstName' : ?2 , 'lastName' : ?3 } }")
    long findAndModifyFirstNameLastNameByAgeBetween(int from, int to, String firstName, String lastName);

    @Query("{ 'role.totalYearOfExperience' : ?0 }")
    @Update("{ '$inc' : { 'age' : ?1 },  {$multi : true } }")
    long findAndModifyAgeByTotalYearOfExperience(int totalYearOfExperience, int incrementBy);

    @Query("{ 'lastName' : ?0 }")
    @Update("{ '$set' : { 'address.country' : ?1 } }")
    long updateAllCountryByLastName(String lastName, String country);

    @Aggregation(pipeline = {
            "{'$match':{'address.country':?0, 'role.totalYearOfExperience': {$gt: ?1} }}",
            "{'$sort':{'age':1}}"
    })
    List<User> findByAggregation(String country, int totalExp);

    @Aggregation("{ '$project': { 'lastName': 1, 'firstName': 1, 'age': 1, 'contact.emailId': 1 } }")
    List<User> checkProjectedValues();

    @Aggregation(pipeline = {"{$project: { month: {$month: $poDate}, year: {$year: $poDate}, amount: 1, poDate: 1 }}"
            , "{$match: {$and : [{year:?0} , {month:?1}] }}"
            , "{$group: { '_id': { month: {$month: $poDate}, year: {$year: $poDate} },totalPrice: {$sum: {$toDecimal:$amount}}, }}"
            , "{$project: { _id: 0, totalPrice: {$toString: $totalPrice} }}"})
    AggregationResults<User> sumPriceThisYearMonth(Integer year, Integer month);
}
