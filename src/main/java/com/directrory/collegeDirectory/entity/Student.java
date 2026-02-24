package com.directrory.collegeDirectory.entity;

import com.directrory.collegeDirectory.common.Role;
import jakarta.persistence.*;
import lombok.Data;
import lombok.extern.slf4j.XSlf4j;

@Data
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(name = "name",nullable = false,length = 50)
    private String name;
    @Column(name = "username",nullable = false,length = 10)
    private String username;
    @Column(name = "pic",columnDefinition = "LONGBLOB")
    @Lob
    private byte [] profile;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "phone",nullable = false,unique = true,length = 10)
    private String phone;
    @Column(name = "password",nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department dept;;
    @Column(name = "year",nullable = false)
    private String year;

}
