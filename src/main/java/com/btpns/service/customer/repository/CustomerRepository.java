package com.btpns.service.customer.repository;

import com.btpns.service.customer.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer , String> {
    //public Optional<Customer> findById(String id);
    //public Customer save(Customer customer);
}