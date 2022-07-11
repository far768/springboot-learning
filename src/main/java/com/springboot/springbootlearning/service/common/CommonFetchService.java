package com.springboot.springbootlearning.service.common;

import com.springboot.springbootlearning.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface CommonFetchService<T> {

    List<T> findAll();

    List<User> findAll(Pageable pageable);

    List<User> findAll(Sort sort);


    Optional<T> findById(String id);

}
