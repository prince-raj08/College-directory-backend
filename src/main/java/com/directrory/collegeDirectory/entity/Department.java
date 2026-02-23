package com.directrory.collegeDirectory.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "dept",nullable = false,unique = true)
    private String dept;
    @Column(name = "description",nullable = false)
    private String description;

}
