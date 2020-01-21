package com.btpns.service.customer.repository;

import com.btpns.service.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer , String> {
    void deleteById(String id);
}