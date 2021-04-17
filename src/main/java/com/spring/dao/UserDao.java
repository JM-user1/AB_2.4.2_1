package com.spring.dao;

import com.spring.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);
    List<User> listUsers();
    void deleteUser(User User);
    void updateUser(User user);
    User getUserById(Long id);
    User getUserByName(String name);
}