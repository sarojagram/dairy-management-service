package com.agraminfotech.dairymanagement.vendorandCustomer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorAndCustomerRepository extends JpaRepository<VendorAndCustomer, Long>,VendorAndCustomerDao {

    boolean existsByEmail(String email);
}
