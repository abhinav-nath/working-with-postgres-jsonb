package com.codecafe.postgres.entity;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {

  private String line1;
  private String line2;
  private String city;
  private String state;
  private int zipCode;

}