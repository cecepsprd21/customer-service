package com.btpns.service.customer.service;

import com.btpns.service.customer.entity.Customer;
import com.btpns.service.customer.repository.CustomerRepository;
import com.btpns.service.customer.response.ResponseDao;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

  @Autowired
  private CustomerRepository customerRepository;

  public List<Customer> findByName(String name){
    List<Customer> customers = customerRepository.findByNameStartingWith(name);
    return customers;
  }

  public ResponseEntity<ResponseDao> findAll() {
    List<Customer> customerList = (List<Customer>) customerRepository.findAll();
    ResponseDao responseDao = new ResponseDao();
    responseDao.setData(customerList);
    responseDao.setCode(200);
    responseDao.setStatus("OK");
    responseDao.setMessage("Successfully");
    return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(responseDao);
  }

  public ResponseEntity<ResponseDao> findAllPagination(Pageable pageable) {
    List<Customer> customerList = (List<Customer>) customerRepository.findAll();
    ResponseDao responseDao = new ResponseDao();
    responseDao.setData(customerList);
    responseDao.setCode(200);
    responseDao.setStatus("OK");
    responseDao.setMessage("Successfully");
    return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(responseDao);
  }

  public ResponseEntity<ResponseDao> findById(String id) {
    ResponseDao responseDao = new ResponseDao();
    Optional<Customer> customer = customerRepository.findById(id);
    if(customer.isPresent()) {
      responseDao.setData(customer);
      responseDao.setCode(200);
      responseDao.setStatus("OK");
      responseDao.setMessage("Successfully");
      return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(responseDao);
    } else {
      responseDao.setData(null);
      responseDao.setCode(404);
      responseDao.setStatus("NOT FOUND");
      responseDao.setMessage("CUSTOMER NOT FOUND");
      return ResponseEntity.status(404).contentType(MediaType.APPLICATION_JSON).body(responseDao);
    }
  }

  @Transactional
  public ResponseEntity<ResponseDao> create(Customer customer) {
    customerRepository.save(customer);
    ResponseDao responseDao = new ResponseDao();
    responseDao.setData(customer);
    responseDao.setCode(200);
    responseDao.setStatus("OK");
    responseDao.setMessage("Successfully");
    return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(responseDao);
  }

  public ResponseEntity<ResponseDao> update(String id, Customer customerRec) throws NotFoundException {
    Optional<Customer> customer = customerRepository.findById(id);
    ResponseDao responseDao = new ResponseDao();
    if(customer.isPresent()){
      customer.get().setName(customerRec.getName());
      customer.get().setEmail(customerRec.getEmail());
      customer.get().setPhone(customerRec.getPhone());
      customer.get().setAddress(customerRec.getAddress());
      customer.get().setCustomer_nik(customerRec.getCustomer_nik());
      customerRepository.save(customer.get());
      responseDao.setData(customer.get());
      responseDao.setCode(200);
      responseDao.setStatus("OK");
      responseDao.setMessage("Successfully");
      return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(responseDao);
    }else {
      responseDao.setData(null);
      responseDao.setCode(404);
      responseDao.setStatus("NOT FOUND");
      responseDao.setMessage("CUSTOMER NOT FOUND");
      return ResponseEntity.status(404).contentType(MediaType.APPLICATION_JSON).body(responseDao);
    }
  }

  public ResponseEntity<ResponseDao> delete(String id) {
    customerRepository.deleteById(id);
    ResponseDao responseDao = new ResponseDao();
    responseDao.setData(null);
    responseDao.setCode(200);
    responseDao.setStatus("OK");
    responseDao.setMessage("Successfully deleted customer");
    return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(responseDao);
  }

}