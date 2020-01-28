package com.btpns.service.customer.controller;

import com.btpns.service.customer.entity.Customer;
import com.btpns.service.customer.response.ResponseDao;
import com.btpns.service.customer.service.CustomerServiceImpl;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
public class CustomerController {

  @Autowired
  private CustomerServiceImpl customerService;

//  FIND BY ID
  @GetMapping(value = "/customer/{id}")
  public ResponseEntity<ResponseDao> findCustomerId(@PathVariable(value = "id") String id) {
    return customerService.findById(id);
  }

// FIND BY NAME
  @GetMapping(value = "/customer/name/{name}")
  public ResponseEntity<ResponseDao> findByName(@PathVariable(name = "name") String name){
    return  customerService.findByName(name);
  }

//  FIND BY CUSTOMER NIK
  @GetMapping(value = "/customer/nik/{nik}")
  public ResponseEntity<ResponseDao> findByNik(@PathVariable(name = "nik") String nik){
    return  customerService.findByNik(nik);
  }

  @GetMapping(value = "/customers")
  public ResponseEntity<ResponseDao> findAllCustomer(Pageable pageable){
    return  customerService.customerPagination(pageable);
  }

  @PostMapping(value = "/customer")
  public ResponseEntity<ResponseDao> create(@Valid @RequestBody Customer customer){
     return customerService.create(customer);
  }

  @PutMapping(value = "/customer/{id}")
  public ResponseEntity<ResponseDao> update(@PathVariable(value = "id")String id, @Valid @RequestBody Customer customer) throws NotFoundException {
    return customerService.update(id,customer);
  }

  @DeleteMapping(value = "/customer/{id}")
  public ResponseEntity<ResponseDao> delete(@PathVariable(value = "id") String id){
     return customerService.delete(id);
  }

}