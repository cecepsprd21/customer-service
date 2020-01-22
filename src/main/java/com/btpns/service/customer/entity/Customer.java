package com.btpns.service.customer.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "customer")
public class Customer {
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name ="id")
  private String id;

  @Column(name = "customer_no")
  private int customer_no;

  @NotNull(message = "Customer_nik can't be null")
  @Size(min = 16, message = "Customer nik min 16")
  @Pattern(regexp="^(0|[1-9][0-9]*)$", message = "Customer_nik must be a number")
  private String customer_nik;

  @Column(name = "name")
  @NotNull(message = "Name can't be null")
  @Size(min = 2, max = 50)
  private String name;

  @NotNull(message = "Email can't be null")
  @Email @Size(max = 50)
  private String email;

  @NotNull(message = "Address can't be null")
  private String address;

  @Pattern(regexp="^(0|[1-9][0-9]*)$", message = "Phone must be a number")
  @NotNull(message = "Phone can't be null")
  @Size(min = 10, max = 12)
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

  public String getCustomer_nik() {
    return customer_nik;
  }

  public void setCustomer_nik(String co_nik) {
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
