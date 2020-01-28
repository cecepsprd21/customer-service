//package com.btpns.service.customer;
//
//import com.btpns.service.customer.controller.CustomerController;
//import com.btpns.service.customer.entity.Customer;
//import com.btpns.service.customer.response.ResponseDao;
//import com.btpns.service.customer.service.CustomerServiceImpl;
//import org.junit.Test;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.mock.web.MockHttpServletRequest;
//import org.springframework.test.web.servlet.ResultMatcher;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//import org.testng.annotations.AfterTest;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest
//public class customer_test {
//
//  @Autowired
//  MockMvc mockMvc;
//
//  @MockBean
//  private CustomerServiceImpl customerService;
//
//  @Test
//  public void findById() throws Exception {
//
//    Customer customer = new Customer();
//    customer.setId("8e8a79c1-e121-46e2-b6e7-14812da8cf23");
//    customer.setCustomer_no("NA-OO1");
//    customer.setCustomer_nik("12332112");
//    customer.setName("Cecep Supriadi");
//    customer.setEmail("cecepsprd@gmail.com");
//    customer.setPhone("89009889098");
//    customer.setAddress("Bekasi");
//    System.out.println(customer.getId() + "----------------------------------------------");
//
//    List<Customer> customerList = Arrays.asList(customer);
//    ResponseDao responseDao = new ResponseDao();
//
//    responseDao.setData(customerList);
//    responseDao.setCode(200);
//    responseDao.setStatus("OK");
//    responseDao.setMessage("Successfully");
//
//    given(customerService.findByName("ce")).willReturn(
//     ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(responseDao)
//    );
//
//  }
//}
//
//
//
//
