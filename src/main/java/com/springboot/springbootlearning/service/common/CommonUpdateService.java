package com.springboot.springbootlearning.service.common;

import java.util.List;
import java.util.Optional;

public interface CommonUpdateService<T> {

    List<T> updateAll(List<T> t);

    Optional<T> updateById(T t);

    List<T> updateByFirstName(String firstName, T t);

    List<T> updateByLastName(String lastName, T t);

    List<T> updateByLastNameAndFirstName(String lastName, String firstName, T t);

    List<T> updateByAge(int age, T t);

    List<T> updateByContactMobileNumberOrEmailId(String mobileNumber, String emailId, T t);

    boolean updateFirstNameLastNameById(String id, String firstName, String lastName);

}
