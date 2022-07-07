package com.springboot.springbootlearning.service.common;

import java.util.List;

public interface CommonCreateService<T> {

    T save(T t);

    List<T> saveAll(List<T> t);

}
