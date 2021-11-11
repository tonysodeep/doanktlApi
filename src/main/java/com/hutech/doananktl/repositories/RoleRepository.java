package com.hutech.doananktl.repositories;

import com.hutech.doananktl.models.ERole;
import com.hutech.doananktl.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}