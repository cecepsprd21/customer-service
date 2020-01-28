package com.btpns.service.customer.repository;

import com.btpns.service.customer.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer , String> , PagingAndSortingRepository<Customer,String> {

    Page<Customer> findAll(Pageable pageable);

    @Query("SELECT c FROM Customer c WHERE c.name LIKE %?1%")
    List<Customer> findByName(String name);

    List<Customer> findByEmail(String email);

    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Customer c WHERE c.email LIKE %?1%")
    boolean existsByEmail(String email);

    @Query("SELECT c FROM Customer c WHERE c.phone LIKE %?1%")
    Customer findByPhone(String phone);

    @Query("SELECT c FROM Customer c WHERE c.customer_nik LIKE %?1%")
    List<Customer> findByNik(String nik);

}