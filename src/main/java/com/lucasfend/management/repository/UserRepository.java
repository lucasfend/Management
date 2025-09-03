package com.lucasfend.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucasfend.management.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
