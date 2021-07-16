package com.example.cassandra.cassandrademo.controller;

import com.example.cassandra.cassandrademo.ResouceNotFoundException;
import com.example.cassandra.cassandrademo.model.User;
import com.example.cassandra.cassandrademo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/user")
    public User addUser(@RequestBody User user){
        userRepository.save(user);
        return user;

    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") Integer userId){
        User user=userRepository.findById(userId).orElseThrow(
                () -> new ResouceNotFoundException("User not found " + userId));
        return ResponseEntity.ok().body(user);
    }


    @GetMapping("/users")
    public List<User> getProducts(){

        return userRepository.findAll();
    }

    @PutMapping("user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Integer userId,
                                                 @RequestBody User userDetails) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResouceNotFoundException("User not found for this id: " + userId));
        user.setName(userDetails.getName());
        final User updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);

    }

    @DeleteMapping("user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable(value = "id") Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResouceNotFoundException("Product not found::: " + userId));
        userRepository.delete(user);
        return ResponseEntity.ok().build();
    }

}
