package com.btpns.service.customer;

import com.btpns.service.customer.controller.CustomerController;
import com.btpns.service.customer.entity.Customer;
import com.btpns.service.customer.response.ResponseDao;
import com.btpns.service.customer.service.CustomerService;
import com.btpns.service.customer.service.CustomerServiceImpl;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@SpringBootTest
public class customer2_test {

  @InjectMocks
  CustomerController customerController;

  @Mock
  CustomerServiceImpl customerService;

  @Test
  public void findByIdTest(){
    MockHttpServletRequest request = new MockHttpServletRequest();
    RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

    Customer customer = new Customer();
    customer.setId("8e8a79c1-e121-46e2-b6e7-14812da8cf23");
    customer.setCustomer_no("NA-OO1");
    customer.setCustomer_nik("12332112");
    customer.setName("Cecep Supriadi");
    customer.setEmail("cecepsprd@gmail.com");
    customer.setPhone("89009889098");
    customer.setAddress("Bekasi");
    System.out.println(customer.getId() + "----------------------------------------------");

    ResponseDao responseDao = new ResponseDao();

    responseDao.setData(customer);
    responseDao.setCode(200);
    responseDao.setStatus("OK");
    responseDao.setMessage("Successfully ---");

    when(customerService.findById(customer.getId())).thenReturn(
            ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(responseDao)
    );

    ResponseEntity<ResponseDao> daoResponseEntity = customerController.findCustomerId(customer.getId());

    assertThat(daoResponseEntity.getStatusCodeValue()).isEqualTo(200);

    System.out.println(daoResponseEntity.getBody().getMessage() + "*******************************");

  }

  @Test
  public void createCustomer(){

    MockHttpServletRequest request = new MockHttpServletRequest();
    RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

    Customer customer = new Customer();
//    customer.setId("8e8a79c1-e121-46e2-b6e7-14812da8cf23");
//    customer.setCustomer_no("NA-OO1");
    customer.setCustomer_nik("12332112");
    customer.setName("Cecep Supriadi");
    customer.setEmail("cecepsprd@gmail.com");
    customer.setPhone("89009889098");
    customer.setAddress("Bekasi");
    System.out.println(customer.getId() + "----------------------------------------------");

    ResponseDao responseDao = new ResponseDao();

    responseDao.setData(customer);
    responseDao.setCode(201);
    responseDao.setStatus("Created");
    responseDao.setMessage("Successfully Created");

    when(customerService.create(customer)).thenReturn(
            ResponseEntity.status(201).contentType(MediaType.APPLICATION_JSON).body(responseDao)
    );

    ResponseEntity<ResponseDao> daoResponseEntity = customerController.create(customer);

    assertThat(daoResponseEntity.getStatusCodeValue()).isEqualTo(201);

  }

}














