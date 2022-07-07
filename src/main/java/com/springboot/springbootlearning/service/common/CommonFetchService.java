package com.springboot.springbootlearning.service.common;

import java.util.List;
import java.util.Optional;

public interface CommonFetchService<T> {

    List<T> findAll();

    Optional<T> findById(String id);

    List<T> findByFirstName(String firstName);

    List<T> findByLastName(String lastName);

    List<T> findByLastNameAndFirstName(String lastName, String firstName);
    List<T> findByAge(int age);

    List<T> findByContactMobileNumberOrEmailId(String mobileNumber, String emailId);

}
