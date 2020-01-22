package com.btpns.service.customer.service;

import com.btpns.service.customer.entity.Customer;
import com.btpns.service.customer.repository.CustomerRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

  @Autowired
  private CustomerRepository customerRepository;

  public List<Customer> findAll() {
   return (List<Customer>) customerRepository.findAll();
  }

  public Customer findById(String id) {
    return customerRepository.findById(id).get();
  }

  @Transactional
  public Customer create(Customer customer) {
    return customerRepository.save(customer);
  }

  public Customer update(String id, Customer customerRec) throws NotFoundException {
    Customer customer = customerRepository.findById(id).orElseThrow(() -> new NotFoundException("Employee not found"));
    customer.setName(customerRec.getName());
    customer.setEmail(customerRec.getEmail());
    customer.setPhone(customerRec.getPhone());
    customer.setAddress(customerRec.getAddress());
    customer.setCustomer_nik(customerRec.getCustomer_nik());
    customerRepository.save(customer);
    return customer;
  }

  public void delete(String id) {
    customerRepository.deleteById(id);
  }
}