package com.agraminfotech.dairymanagement.security.user;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, UserDao {

   User findByUsername(String username);

   boolean existsByUsername(String username);

   boolean existsByEmail(String email);

   Optional<User> findOneByUsername(String username);
}
