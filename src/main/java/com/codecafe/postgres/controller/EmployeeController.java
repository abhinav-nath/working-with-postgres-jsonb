package com.codecafe.postgres.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codecafe.postgres.dto.EmployeeDTO;
import com.codecafe.postgres.entity.Address;
import com.codecafe.postgres.entity.ContactInfo;
import com.codecafe.postgres.entity.Employee;
import com.codecafe.postgres.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

  private final EmployeeService employeeService;

  public EmployeeController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @GetMapping("/{id}")
  public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
    return ResponseEntity.ok(employeeService.getEmployee(id));
  }

  @PostMapping
  public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
    Employee employee = employeeService.createEmployee(employeeDTO);

    if (employee == null) {
      throw new RuntimeException("Employee could not be created");
    }

    return new ResponseEntity<>(employee, HttpStatus.CREATED);
  }

  @PutMapping("/{id}/address")
  public ResponseEntity<Employee> updateAddress(@PathVariable Long id, @RequestBody Address address) {
    Employee employee = employeeService.updateAddress(id, address);

    if (employee == null) {
      throw new RuntimeException("Address could not be updated");
    }

    return new ResponseEntity<>(employee, HttpStatus.OK);
  }

  @PutMapping("/{id}/contactinfo")
  public ResponseEntity<Employee> updateContactInfo(@PathVariable Long id, @RequestBody ContactInfo contactInfo) {
    Employee employee = employeeService.updateContactInfo(id, contactInfo);

    if (employee == null) {
      throw new RuntimeException("ContactInfo could not be updated");
    }

    return new ResponseEntity<>(employee, HttpStatus.OK);
  }

}