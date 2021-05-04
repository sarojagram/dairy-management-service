package com.agraminfotech.dairymanagement.product.attribute;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeRepository extends JpaRepository<Attribute, Long>, AttributeDao {
    boolean existsByName(String username);
}
