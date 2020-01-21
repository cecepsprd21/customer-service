package com.btpns.service.customer.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "customer")
public class Customer {
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private String id;

  @Column(unique = true)
  private int customer_no;

  @NotNull @Size(min = 16)
  @Column(name = "customer_nik", unique = true)
  private String customer_nik;

  @Column(name = "name", unique = true)
  @NotNull @Size(min = 2, max = 50)
  private String name;

  @Column(unique = true)
  @NotNull @Email @Size(max = 50)
  private String email;

  @NotNull
  private String address;

  @Column(unique = true)
  @NotNull @Size(min = 11, max = 13)
  private String phone;

  //GETTER SETTER
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public int getCustomer_no() {
    return customer_no;
  }

  public void setCustomer_no(int customer_no) {
    this.customer_no = customer_no;
  }

  public String getCo_nik() {
    return customer_nik;
  }

  public void setCo_nik(String co_nik) {
    this.customer_nik = co_nik;
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
