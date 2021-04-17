package com.spring.service;

import com.spring.dao.RoleDao;
import com.spring.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Transactional
public class RoleServiceImp implements RoleService {

    private final RoleDao roleDao;

    @Autowired
    public RoleServiceImp(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Set<UserRole> getRoleSet(Set<String> roles) {
        return roleDao.getRoleSet(roles);
    }

    @Override
    public UserRole getDefaultRole() {
        return roleDao.getDefaultRole();
    }
}
