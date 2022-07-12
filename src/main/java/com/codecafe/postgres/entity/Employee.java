package com.codecafe.postgres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import lombok.Getter;
import lombok.Setter;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity
@Table(name = "employees", schema = "test_schema")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class Employee {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Integer id;

  @Type(type = "jsonb")
  @Column(columnDefinition = "jsonb")
  private Bio bio;

}