package com.btpns.service.customer.controller;

import com.btpns.service.customer.entity.Customer;
import com.btpns.service.customer.service.CustomerServiceImpl;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
public class CustomerController {

  @Autowired
  private CustomerServiceImpl customerService;

  @GetMapping(value = "/customer/{id}")
  @ResponseBody
  public Customer findCustomerId(@PathVariable(value = "id") String id){
    return customerService.findById(id);
  }

  @GetMapping(value = "/customer")
  @ResponseBody
  public List<Customer> findAllCustomer(){
    return  customerService.findAll();
  }

  @PostMapping(value = "/customer")
  @ResponseBody
  public Customer create(@Valid @RequestBody Customer customer){
     return customerService.create(customer);
  }

  @PutMapping(value = "/customer/{id}")
  @ResponseBody
  public Customer update(@PathVariable(value = "id")String id, @Valid @RequestBody Customer customer) throws NotFoundException {
    return customerService.update(id,customer);
  }

  @DeleteMapping(value = "/customer/{id}")
  @ResponseBody
  public void delete(@PathVariable(value = "id") String id){
     customerService.delete(id);
  }
}