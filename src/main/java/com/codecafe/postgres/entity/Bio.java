package com.codecafe.postgres.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Bio {

  private String firstName;
  private String lastName;
  private Date dob;
  private Address address;
  private ContactInfo contactInfo;

}
