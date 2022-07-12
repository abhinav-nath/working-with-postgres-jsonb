package com.codecafe.postgres.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.codecafe.postgres.entity.Address;
import com.codecafe.postgres.entity.ContactInfo;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

  private String firstName;
  private String lastName;
  private Date dob;
  private Address address;
  private ContactInfo contactInfo;

}