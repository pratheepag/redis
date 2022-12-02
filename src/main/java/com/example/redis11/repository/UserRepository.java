package com.example.redis11.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.redis11.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> { }
