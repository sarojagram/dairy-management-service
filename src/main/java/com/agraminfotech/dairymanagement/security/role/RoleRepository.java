package com.agraminfotech.dairymanagement.security.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>,RoleDao {

    Role findByName(String name);
}
