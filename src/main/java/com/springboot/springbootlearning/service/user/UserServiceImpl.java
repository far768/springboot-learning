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
    public void deleteByFirstName(String firstName) {
        repository.deleteByFirstName(firstName);
    }

    @Override
    public void deleteByLastName(String lastName) {
        repository.deleteByLastName(lastName);
    }

    @Override
    public void deleteByLastNameAndFirstName(String lastName, String firstName) {
        repository.deleteByLastNameAndFirstName(lastName, firstName);
    }

    @Override
    public void deleteByAge(int age) {
        repository.deleteByAge(age);
    }

    @Override
    public void deleteByContactMobileNumberOrEmailId(String mobileNumber, String emailId) {
        repository.deleteByContactMobileNumberOrContactEmailId(mobileNumber, emailId);
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
    public List<String> findAllLastnames() {
        return repository.findAllLastnames();
    }

    @Override
    public boolean updateAllAgeByAge(int age, int incrementBy) {
         repository.updateAllAgeByAge(age, incrementBy);
         return true;
    }

    @Override
    public boolean updateAllCountryBylastName(String lastName, String country) {
        repository.updateAllCountryBylastName(lastName, country);
        return true;
    }

    @Override
    public Optional<User> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<User> findByFirstName(String firstName) {
        return repository.findByFirstName(firstName);
    }

    @Override
    public List<User> findByLastName(String lastName) {
        return repository.findByLastName(lastName);
    }

    @Override
    public List<User> findByLastNameAndFirstName(String lastName, String firstName) {
        return repository.findByLastNameAndFirstName(lastName, firstName);
    }

    @Override
    public List<User> findByAge(int age) {
        return repository.findByAge(age);
    }

    @Override
    public List<User> findByContactMobileNumberOrEmailId(String mobileNumber, String emailId) {
        return repository.findByContactMobileNumberOrContactEmailId(mobileNumber, emailId);
    }

    @Override
    public List<User> updateAll(List<User> t) {
        return repository.saveAll(t);
    }

    @Override
    public Optional<User> updateById(User user) {
//        return repository.updateById(user);
        return null;
    }

    @Override
    public List<User> updateByFirstName(String firstName, User user) {
//        return repository.updateByFirstName(firstName, user);
        return null;
    }

    @Override
    public List<User> updateByLastName(String lastName, User user) {
//        return repository.updateByLastName(lastName, user);
        return null;
    }

    @Override
    public List<User> updateByLastNameAndFirstName(String lastName, String firstName, User user) {
//        return repository.updateByLastNameAndFirstName(lastName, firstName, user);
        return null;
    }

    @Override
    public List<User> updateByAge(int age, User user) {
//        return repository.updateByAge(age, user);
        return null;
    }

    @Override
    public List<User> updateByContactMobileNumberOrEmailId(String mobileNumber, String emailId, User user) {
//        return repository.updateByContactMobileNumberOrContactEmailId(mobileNumber, emailId, user);
        return null;
    }

    @Override
    public List<User> updateFirstNameLastNameById(String id, String firstName, String lastName) {
//        return repository.updateFirstNameLastNameById(id, firstName, lastName);
        return null;
    }

}
