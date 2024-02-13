package com.example.azurewbapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    CustomerRepository repository;

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody Customer customer){
        logger.info("Inside save method");
        repository.save(customer);
        return new ResponseEntity<>("Successs", HttpStatus.OK);

    }

    @GetMapping("/getuser")
    public ResponseEntity<Customer> getUser(@RequestParam Long userid){
        logger.info("inside get method");
       Optional<Customer> res = repository.findById(userid);
       return new ResponseEntity<>(res.get(),HttpStatus.OK);
    }
}
