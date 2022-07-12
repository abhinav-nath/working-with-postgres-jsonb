package com.codecafe.postgres.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

  private String line1;
  private String line2;
  private String city;
  private String state;
  private int zipCode;

}