package com.springboot.springbootlearning.controller;

import com.springboot.springbootlearning.model.User;
import com.springboot.springbootlearning.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/save")
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @PostMapping("/saveAll")
    public List<User> saveAll(@RequestBody List<User> t) {
        return userService.saveAll(t);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAll() {
        userService.deleteAll();
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable String id) {
        userService.deleteById(id);
    }

    @DeleteMapping("/deleteByFirstName/{firstName}")
    public void deleteByFirstName(@PathVariable String firstName) {
        userService.deleteByFirstName(firstName);
    }

    @DeleteMapping("/deleteByLastName/{lastName}")
    public void deleteByLastName(@PathVariable String lastName) {
        userService.deleteByLastName(lastName);
    }

    @DeleteMapping("/deleteByLastNameAndFirstName")
    public void deleteByLastNameAndFirstName(@RequestParam String lastName, @RequestParam String firstName) {
        userService.deleteByLastNameAndFirstName(lastName, firstName);
    }

    @DeleteMapping("/deleteByAge/{age}")
    public void deleteByAge(@PathVariable int age) {
        userService.deleteByAge(age);
    }

    @DeleteMapping("/deleteByContactMobileNumberOrEmailId")
    public void deleteByContactMobileNumberOrEmailId(@RequestParam String mobileNumber, @RequestParam String emailId) {
        userService.deleteByContactMobileNumberOrEmailId(mobileNumber, emailId);
    }

    @GetMapping("/findAll")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/findAllUsingPagination")
    public List<User> findAllUsingPagination(@RequestParam int pageNumber, @RequestParam int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        return userService.findAll(pageable);
    }

    @GetMapping("/findAllUsingSorting")
    public List<User> findAllUsingSorting(@RequestParam String properties) {
        Sort sort = Sort.by(Sort.Direction.ASC, properties.split(",")[0], properties.split(",")[1]);
        return userService.findAll(sort);
    }

    @GetMapping("/findById/{id}")
    public Optional<User> findById(@PathVariable String id) {
        return userService.findById(id);
    }

    @GetMapping("/findByFirstName/{firstName}")
    public List<User> findByFirstName(@PathVariable String firstName) {
        return userService.findByFirstName(firstName);
    }

    @GetMapping("/findByLastName/{lastName}")
    public List<User> findByLastName(@PathVariable String lastName) {
        return userService.findByLastName(lastName);
    }

    @GetMapping("/findByLastNameAndFirstName")
    public List<User> findByLastNameAndFirstName(@RequestParam String lastName, @RequestParam String firstName) {
        return userService.findByLastNameAndFirstName(lastName, firstName);
    }

    @GetMapping("/findByAge/{age}")
    public List<User> findByAge(@PathVariable int age) {
        return userService.findByAge(age);
    }

    @GetMapping("/findByContactMobileNumberOrEmailId")
    public List<User> findByContactMobileNumberOrEmailId(@RequestParam String mobileNumber, @RequestParam String emailId) {
        return userService.findByContactMobileNumberOrEmailId(mobileNumber, emailId);
    }

    @PutMapping("/updateAll")
    public List<User> updateAll(@RequestBody List<User> t) {
        return userService.saveAll(t);
    }

    @PutMapping("/updateById")
    public Optional<User> updateById(@RequestBody User user) {
        return userService.updateById(user);
    }

    @PutMapping("/updateByFirstName/{firstName}")
    public List<User> updateByFirstName(@PathVariable String firstName, @RequestBody User user) {
        return userService.updateByFirstName(firstName, user);
    }

    @PutMapping("/updateByLastName/{lastName}")
    public List<User> updateByLastName(@PathVariable String lastName, @RequestBody User user) {
        return userService.updateByLastName(lastName, user);
    }

    @PutMapping("/updateByLastNameAndFirstName")
    public List<User> updateByLastNameAndFirstName(@RequestParam String lastName, @RequestParam String firstName, @RequestBody User user) {
        return userService.updateByLastNameAndFirstName(lastName, firstName, user);
    }

    @PutMapping("/updateByAge/{age}")
    public List<User> updateByAge(@PathVariable int age, @RequestBody User user) {
        return userService.updateByAge(age, user);
    }

    @PutMapping("/updateByContactMobileNumberOrEmailId")
    public List<User> updateByContactMobileNumberOrEmailId(@RequestParam String mobileNumber, @RequestParam String emailId, @RequestBody User user) {
        return userService.updateByContactMobileNumberOrEmailId(mobileNumber, emailId, user);
    }

    @PutMapping("/updateFirstNameLastNameById")
    public List<User> updateFirstNameLastNameById(String id, @RequestBody User user) {
        return userService.updateFirstNameLastNameById(id, user.getFirstName(), user.getLastName());
    }
}
