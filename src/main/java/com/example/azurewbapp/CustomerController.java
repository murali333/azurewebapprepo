package com.example.azurewbapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerRepository repository;

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody Customer customer){
        repository.save(customer);
        return new ResponseEntity<>("Successs", HttpStatus.OK);

    }

    @GetMapping("/getuser")
    public ResponseEntity<Customer> getUser(@RequestParam Long userid){
       Optional<Customer> res = repository.findById(userid);
       return new ResponseEntity<>(res.get(),HttpStatus.OK);
    }
}
