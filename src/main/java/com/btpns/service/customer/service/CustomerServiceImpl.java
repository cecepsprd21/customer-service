package com.btpns.service.customer.service;

import com.btpns.service.customer.entity.Customer;
import com.btpns.service.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

  @Autowired
  private CustomerRepository customerRepository;

  public List<Customer> findAll() {
    return customerRepository.findAll();
  }

  public Customer findById(String id) {
    return customerRepository.getOne(id);
  }

  public Customer create(Customer customer) {
    return customerRepository.save(customer);
  }

  public Customer update(String id, Customer customerRec){
    Customer customer = findById(id);
    customer.setName(customerRec.getName());
    customer.setEmail(customerRec.getEmail());
    customer.setCustomer_no(customerRec.getCustomer_no());
    customer.setCustomer_nik(customerRec.getCustomer_nik());
    customer.setPhone(customerRec.getPhone());
    customer.setAddress(customerRec.getAddress());
    return customerRepository.save(customer);
  }

  public void delete(String id) {
    customerRepository.deleteById(id);
  }

}
