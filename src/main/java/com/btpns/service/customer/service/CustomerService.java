package com.btpns.service.customer.service;

import com.btpns.service.customer.entity.Customer;
import javassist.NotFoundException;
import java.util.List;

public interface CustomerService {

  List<Customer> findAll();

  Customer findById(String id);

  Customer create(Customer customer);

  Customer update(String id, Customer customer) throws NotFoundException;

  void delete(String id);

}