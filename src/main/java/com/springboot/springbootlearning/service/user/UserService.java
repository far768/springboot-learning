package com.springboot.springbootlearning.service.user;


import com.springboot.springbootlearning.model.User;
import com.springboot.springbootlearning.service.common.CommonCreateService;
import com.springboot.springbootlearning.service.common.CommonDeleteService;
import com.springboot.springbootlearning.service.common.CommonFetchService;
import com.springboot.springbootlearning.service.common.CommonUpdateService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface UserService extends CommonCreateService<User>, CommonUpdateService<User>, CommonDeleteService<User>, CommonFetchService<User> {
    List<User> findAll(Pageable pageable);

    List<User> findAll(Sort sort);

}
