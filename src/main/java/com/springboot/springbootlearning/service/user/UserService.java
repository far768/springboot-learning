package com.springboot.springbootlearning.service.user;


import com.springboot.springbootlearning.model.User;
import com.springboot.springbootlearning.service.common.CommonCreateService;
import com.springboot.springbootlearning.service.common.CommonDeleteService;
import com.springboot.springbootlearning.service.common.CommonFetchService;
import com.springboot.springbootlearning.service.common.CommonUpdateService;

public interface UserService extends CommonCreateService<User>, CommonUpdateService<User>, CommonDeleteService<User>, CommonFetchService<User> {

}
