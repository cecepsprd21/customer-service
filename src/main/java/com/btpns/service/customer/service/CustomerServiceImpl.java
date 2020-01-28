package com.btpns.service.customer.service;

import com.btpns.service.customer.entity.Customer;
import com.btpns.service.customer.repository.CustomerRepository;
import com.btpns.service.customer.response.ResponseDao;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

  @Autowired
  private CustomerRepository customerRepository;

//  FIND BY NAME
  public ResponseEntity<ResponseDao> findByName(String name){
    List<Customer> customers = customerRepository.findByName(name);
    ResponseDao responseDao = new ResponseDao();
    if(customers.isEmpty()){
      responseDao.setData(null);
      responseDao.setCode(404);
      responseDao.setStatus("NOT FOUND");
      responseDao.setMessage("Customer with name " + name + " not found");
      return ResponseEntity.status(404).contentType(MediaType.APPLICATION_JSON).body(responseDao);
    } else {
      responseDao.setData(customers);
      responseDao.setCode(200);
      responseDao.setStatus("OK");
      responseDao.setMessage("Successfully");
      return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(responseDao);
    }
  }

  // PAGINATION
  public ResponseEntity<ResponseDao> customerPagination(Pageable pageable) {
    Page<Customer> customerPage = customerRepository.findAll(pageable);
    ResponseDao responseDao = new ResponseDao();
    if (customerPage.isEmpty()) {
      responseDao.setData(null);
      responseDao.setCode(404);
      responseDao.setStatus("NOT FOUND");
      responseDao.setMessage("Customer Empty");
      return ResponseEntity.status(404).contentType(MediaType.APPLICATION_JSON).body(responseDao);
    } else {
      responseDao.setData(customerPage);
      responseDao.setCode(200);
      responseDao.setStatus("OK");
      responseDao.setMessage("Successfully");
      return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(responseDao);
    }
  }

  // FIND BY ID
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

  @Override
  public ResponseEntity<ResponseDao> findByNik(String nik) {
    List<Customer> customerNik = customerRepository.findByNik(nik);
    ResponseDao responseDao = new ResponseDao();
    if (customerNik.isEmpty()) {
      responseDao.setData(null);
      responseDao.setCode(404);
      responseDao.setStatus("NOT FOUND");
      responseDao.setMessage("Customer with co nik " + nik + "Not Found");
      return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(responseDao);
    } else {
      responseDao.setData(customerNik);
      responseDao.setCode(200);
      responseDao.setStatus("OK");
      responseDao.setMessage("Successfully");
      return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(responseDao);
    }
  }

  //CREATE
  @Transactional
  public ResponseEntity<ResponseDao> create(Customer customer) {
    ResponseDao responseDao = new ResponseDao();
    long sizeList = customerRepository.count() + 1;
    customer.setCustomer_no("NA-00" + Long.toString(sizeList));
      responseDao.setData(customer);
      responseDao.setCode(201);
      responseDao.setStatus("OK");
      responseDao.setMessage("Successfully created customer");
      customerRepository.save(customer);
      return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(responseDao);
  }

  // UPDATE
  public ResponseEntity<ResponseDao> update(String id, Customer customerRec) throws NotFoundException {
    Optional<Customer> customer = customerRepository.findById(id);
    ResponseDao responseDao = new ResponseDao();
    if(customer.isPresent()) {
      customer.get().setName(customerRec.getName());
      customer.get().setAddress(customerRec.getAddress());
      customer.get().setCustomer_nik(customerRec.getCustomer_nik());
      customer.get().setEmail(customerRec.getEmail());
      customer.get().setPhone(customerRec.getPhone());
      customerRepository.save(customer.get());
      responseDao.setData(customer.get());
      responseDao.setCode(200);
      responseDao.setStatus("OK");
      responseDao.setMessage("Successfully updated data");
      return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(responseDao);
    // IF NOT PRESENT
    } else {
      responseDao.setData(null);
      responseDao.setCode(404);
      responseDao.setStatus("NOT FOUND");
      responseDao.setMessage("CUSTOMER NOT FOUND");
      return ResponseEntity.status(404).contentType(MediaType.APPLICATION_JSON).body(responseDao);
    }
  }

  // DELETE
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