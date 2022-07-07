package com.springboot.springbootlearning.service.common;

import java.util.List;
import java.util.Optional;

public interface CommonDeleteService<T> {

    void deleteAll();

    void deleteById(String id);

    void deleteByFirstName(String firstName);

    void deleteByLastName(String lastName);

    void deleteByLastNameAndFirstName(String lastName, String firstName);

    void deleteByAge(int age);

    void deleteByContactMobileNumberOrEmailId(String mobileNumber, String emailId);

}
