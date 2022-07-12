package com.codecafe.postgres.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codecafe.postgres.dto.EmployeeDTO;
import com.codecafe.postgres.entity.Address;
import com.codecafe.postgres.entity.Bio;
import com.codecafe.postgres.entity.ContactInfo;
import com.codecafe.postgres.entity.Employee;
import com.codecafe.postgres.repository.EmployeeRepository;

@Service
public class EmployeeService {

  private final EmployeeRepository employeeRepository;

  public EmployeeService(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  public Employee getEmployee(Long id) {
    Optional<Employee> employee = employeeRepository.findById(id);
    return employee.orElse(null);
  }

  public Employee createEmployee(EmployeeDTO employeeDTO) {
    Employee employee = new Employee();
    if (employeeDTO != null) {
      Bio bio = new Bio();
      if (employeeDTO.getAddress() != null) {
        bio.setAddress(employeeDTO.getAddress());
      }
      if (employeeDTO.getContactInfo() != null) {
        bio.setContactInfo(employeeDTO.getContactInfo());
      }
      bio.setFirstName(employeeDTO.getFirstName());
      bio.setLastName(employeeDTO.getLastName());
      bio.setDob(employeeDTO.getDob());
      employee.setBio(bio);

      return employeeRepository.save(employee);
    }
    return null;
  }

  public Employee updateAddress(Long id, Address address) {
    Employee existingEmployee = getEmployee(id);
    if (existingEmployee != null && existingEmployee.getBio() != null) {
      existingEmployee.getBio().setAddress(address);
      return employeeRepository.save(existingEmployee);
    }
    return null;
  }

  public Employee updateContactInfo(Long id, ContactInfo contactInfo) {
    Employee existingEmployee = getEmployee(id);
    if (existingEmployee != null && existingEmployee.getBio() != null) {
      existingEmployee.getBio().setContactInfo(contactInfo);
      return employeeRepository.save(existingEmployee);
    }
    return null;
  }

}
