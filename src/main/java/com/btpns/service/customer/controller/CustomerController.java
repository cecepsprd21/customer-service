package com.btpns.service.customer.controller;

import com.btpns.service.customer.entity.Customer;
import com.btpns.service.customer.response.ResponseDao;
import com.btpns.service.customer.service.CustomerServiceImpl;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.awt.print.Pageable;
import java.util.List;

@RestController
public class CustomerController {

  @Autowired
  private CustomerServiceImpl customerService;

  @GetMapping(value = "/customer/{id}")
  public ResponseEntity<ResponseDao> findCustomerId(@PathVariable(value = "id") String id) {
    return customerService.findById(id);
  }

  @GetMapping(value = "/customer")
  @ResponseBody
  public ResponseEntity<ResponseDao> findAllCustomer(){
    return  customerService.findAll();
  }


  @GetMapping(value = "/customers/page")
  @ResponseBody
  public ResponseEntity<ResponseDao> findAllCustomerPagination(Pageable pageable){
    return  customerService.findAllPagination(pageable);
  }

  @GetMapping(value = "/customers/{name}")
  public List<Customer> findByNamee(@PathVariable(value = "name") String name) {
    return customerService.findByName(name);
  }

  @PostMapping(value = "/customer")
  @ResponseBody
  public ResponseEntity<ResponseDao> create(@Valid @RequestBody Customer customer){
     return customerService.create(customer);
  }

  @PutMapping(value = "/customer/{id}")
  @ResponseBody
  public ResponseEntity<ResponseDao> update(@PathVariable(value = "id")String id, @Valid @RequestBody Customer customer) throws NotFoundException {
    return customerService.update(id,customer);
  }

  @DeleteMapping(value = "/customer/{id}")
  @ResponseBody
  public ResponseEntity<ResponseDao> delete(@PathVariable(value = "id") String id){
     return customerService.delete(id);
  }

}