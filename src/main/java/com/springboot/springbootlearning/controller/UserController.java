package com.springboot.springbootlearning.controller;

import com.springboot.springbootlearning.model.User;
import com.springboot.springbootlearning.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository repository;


    @PostMapping("/save")
    public User save(@RequestBody User user) {
        return repository.save(user);
    }

    @PostMapping("/saveAll")
    public List<User> saveAll(@RequestBody List<User> t) {
        return repository.saveAll(t);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAll() {
        repository.deleteAll();
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable String id) {
        repository.deleteById(id);
    }


    @GetMapping("/findAll")
    public List<User> findAll() {
        return repository.findAll();
    }

    @GetMapping("/findAllUsingPagination")
    public List<User> findAllUsingPagination(@RequestParam int pageNumber, @RequestParam int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        return repository.findAll(pageable).getContent();
    }

    @GetMapping("/findAllUsingSorting")
    public List<User> findAllUsingSorting(@RequestParam String properties) {
        Sort sort = Sort.by(Sort.Direction.DESC, properties);
        return repository.findAll(sort);
    }

    @GetMapping("/findById/{id}")
    public Optional<User> findById(@PathVariable String id) {
        return repository.findById(id);
    }

    // ############## custom find operation
    @PostMapping("/findByRegex/{caseNumber}")
    public List<User> findByRoleTitleRegex(@PathVariable int caseNumber, @RequestBody Map<Integer, Object> map) {
        return switch (caseNumber) {
            case 1 -> repository.findByRoleTitleRegex((String) map.get(caseNumber));
            case 2 -> repository.findByRoleTitleIgnoreCase((String) map.get(caseNumber));
            case 3 -> repository.findByFirstNameIsLike((String) map.get(caseNumber));
            case 4 -> repository.findByActiveIsTrue();
            case 5 -> repository.findByActiveIsFalse();
            default -> null;
        };
    }

    @GetMapping("/findByLastNameAndFirstNameOrContactMobileNumber")
    public List<User> findByContactMobileNumberOrEmailId(@RequestParam String lastName, @RequestParam String firstName,
                                                         @RequestParam String mobileNumber) {
        return repository.findByLastNameAndFirstNameOrContactMobileNumber(lastName, firstName, mobileNumber);
    }

    @GetMapping("/findByAgeBetween")
    public List<User> findByAgeBetween(@RequestParam int from, @RequestParam int to) {
        return repository.findByAgeBetween(from, to);
    }

    @PostMapping("/findByAggregation/{caseNumber}")
    public List<User> findByAggregation(@PathVariable int caseNumber, @RequestBody Map<String, Object> map) {
        return switch (caseNumber) {
            case 1 -> repository.checkProjectedValues();
            case 2 -> repository.findByAggregation((String) map.get("country"), (int) map.get("totalExp"));
            default -> null;
        };
    }

    // ########### custom update operation
    @PutMapping("/findAndModifyFirstNameLastNameByAgeBetween")
    public long findAndModifyFirstNameLastNameByAgeBetween(@RequestBody Map<String, Object> map) {
        return repository.findAndModifyFirstNameLastNameByAgeBetween((int) map.get("from"), (int) map.get("to"),
                (String) map.get("firstName"), (String) map.get("lastName"));
    }

    @PutMapping("/findAndModifyAgeByTotalYearOfExperience")
    public long findAndModifyAgeByTotalYearOfExperience(@RequestParam int totalYearOfExperience, @RequestParam int incrementBy) {
        return repository.findAndModifyAgeByTotalYearOfExperience(totalYearOfExperience, incrementBy);
    }

    @PutMapping("/updateAllCountryByLastName")
    public long updateAllCountryByLastName(@RequestParam String lastName, @RequestParam String country) {
        return repository.updateAllCountryByLastName(lastName, country);
    }

}
