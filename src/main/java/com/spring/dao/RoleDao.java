package com.spring.dao;

import com.spring.model.UserRole;

import java.util.Set;

public interface RoleDao {
    Set<UserRole> getRoleSet(Set<String> role);
    UserRole getDefaultRole();
    UserRole getRoleByName(String name);
}
