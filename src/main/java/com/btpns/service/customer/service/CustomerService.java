package com.btpns.service.customer.service;

import com.btpns.service.customer.entity.Customer;
import com.btpns.service.customer.response.ResponseDao;
import javassist.NotFoundException;
import org.springframework.http.ResponseEntity;

import java.awt.print.Pageable;
import java.util.List;

public interface CustomerService {

  List<Customer> findByName(String name);

  ResponseEntity<ResponseDao> findAll();

  ResponseEntity<ResponseDao> findAllPagination(Pageable pageable);

  ResponseEntity<ResponseDao> findById(String id) throws NotFoundException;

  ResponseEntity<ResponseDao> create(Customer customer);

  ResponseEntity<ResponseDao> update(String id, Customer customer) throws NotFoundException;

  ResponseEntity<ResponseDao> delete(String id);

}