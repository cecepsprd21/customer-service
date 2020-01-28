package com.btpns.service.customer.service;

import com.btpns.service.customer.entity.Customer;
import com.btpns.service.customer.response.ResponseDao;
import javassist.NotFoundException;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface CustomerService {

  ResponseEntity<ResponseDao> findByName(String name);

  ResponseEntity<ResponseDao> customerPagination(Pageable pageable);

  ResponseEntity<ResponseDao> findById(String id);

  ResponseEntity<ResponseDao> findByNik(String nik);

  ResponseEntity<ResponseDao> create(Customer customer);

  ResponseEntity<ResponseDao> update(String id, Customer customer) throws NotFoundException;

  ResponseEntity<ResponseDao> delete(String id);

}