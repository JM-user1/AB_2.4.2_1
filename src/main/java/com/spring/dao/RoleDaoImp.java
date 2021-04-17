package com.spring.dao;

import com.spring.model.UserRole;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.Set;

@Repository
public class RoleDaoImp implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Set<UserRole> getRoleSet(Set<String> role) {
        return new HashSet<>(entityManager.createQuery("SELECT r FROM UserRole r WHERE r.name in (:roleStringSet)")
                .setParameter("roleStringSet", role)
                .getResultList());
    }

    @Override
    public UserRole getDefaultRole() {
        return getRoleByName("USER");
    }

    @Override
    public UserRole getRoleByName(String name) {
        return entityManager.createQuery("SELECT r FROM UserRole r WHERE r.name = :roleName", UserRole.class)
                .setParameter("roleName", name)
                .setMaxResults(1)
                .getSingleResult();
    }
}
