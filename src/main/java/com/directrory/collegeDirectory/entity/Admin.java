package com.directrory.collegeDirectory.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "email",nullable = false,unique = true)
    private String email;
    @Column(name = "phone",nullable = false)
    private String phone;
    @Column(name = "password",nullable = false)
    private String password;
    @ManyToOne
    @JoinColumn(name = "department_id", insertable = false, updatable = false)
    private Department department;


}
