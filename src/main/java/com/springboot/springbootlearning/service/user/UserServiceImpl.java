package com.springboot.springbootlearning.service.user;

import com.springboot.springbootlearning.model.User;
import com.springboot.springbootlearning.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;


    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public List<User> saveAll(List<User> t) {
        return repository.saveAll(t);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public List<User> findAll(Pageable pageable) {
        return repository.findAll(pageable).getContent();
    }

    public List<User> findAll(Sort sort) {
        return repository.findAll(sort);
    }

    @Override
    public Optional<User> findById(String id) {
        return repository.findById(id);
    }

}
