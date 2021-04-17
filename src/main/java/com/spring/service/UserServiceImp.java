package com.spring.service;


import com.spring.dao.UserDao;
import com.spring.model.User;
import com.spring.repository.RoleRepo;
import com.spring.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserDetailsService, UserService{

    UserRepo userRepo;
    UserDao userDao;

    @Autowired
    UserServiceImp(UserDao userDao, UserRepo userRepo) {
        this.userDao = userDao;
        this.userRepo = userRepo;
    }
    @Transactional
    @Override
    public void addUser(User user) {
        userRepo.save(user);
    }
    @Transactional
    @Override
    public List<User> listUsers() {
        return userRepo.findAll();
    }
    @Transactional
    @Override
    public void deleteUser(User user) {
        userRepo.delete(user);
    }
    @Transactional
    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
    @Transactional
    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }
    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }
}
