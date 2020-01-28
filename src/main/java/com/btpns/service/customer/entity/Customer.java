package com.btpns.service.customer.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="customer2")
public class Customer{
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name ="id")
  private String id;

  @Column(name = "customer_no")
  private String customer_no;

  @NotNull(message = "CO nik can't be null")
  @Size(min = 8, max = 8, message = "customer nik must have 8 digit")
  @Pattern(regexp="^(0|[1-9][0-9]*)$", message = "CO nik must be a number")
  private String customer_nik;

  @Column(name = "name")
  @NotNull(message = "Name can't be null")
  @Size(min = 2, max = 50)
  private String name;

  @NotNull(message = "Email can't be null")
  @Email @Size(max = 50)
  @Column(name = "email", unique = true, nullable = false)
  private String email;

  @NotNull(message = "Address can't be null")
  private String address;

  @Pattern(regexp="^(0|[1-9][0-9]*)$", message = "Phone must be a number")
  @NotNull(message = "Phone can't be null")
  @Size(min = 10, max = 12)
  @Column(name = "phone", unique = true, nullable = false)
  private String phone;

  //GETTER SETTER
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCustomer_no() {
    return customer_no;
  }

  public void setCustomer_no(String customer_no) {
    this.customer_no = customer_no;
  }

  public String getCustomer_nik() {
    return customer_nik;
  }

  public void setCustomer_nik(String customer_nik) {
    this.customer_nik = customer_nik;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }
}