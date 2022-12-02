package com.example.redis11.controller;

import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import com.example.redis11.model.User;
import com.example.redis11.repository.UserRepository;

@RestController
public class UserController {

  private static final Logger LOG = Logger.getLogger(UserController.class.getName());

  private final UserRepository userRepository;

  @Autowired
  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }
  
  @Cacheable(value = "users", key = "#userId")
  @GetMapping(value = "/{userId}")
  public User getUser(@PathVariable String userId) {
    LOG.info(() -> String.format("Getting user with ID %s.", userId));
    Optional<User> user = userRepository.findById(Long.valueOf(userId));
    return user.isPresent() ? user.get() : null;
  }
  
  @CachePut(value = "users", key = "#user.id")
  @PutMapping("/update")
  public User updatePersonByID(@RequestBody  User user) {
    userRepository.save(user);
    return user;
  }
  
  @CacheEvict(value = "users", allEntries=true)
  @DeleteMapping("/{id}")
  public void deleteUserByID(@PathVariable Long id) {
    LOG.info(() -> String.format("deleting person with id %s.", id));
    userRepository.deleteById(id);
  }
  
}
