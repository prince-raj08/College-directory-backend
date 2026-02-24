package com.directrory.collegeDirectory.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "faculty_profile")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FacultyProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true)
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "office_hours")
    private String officeHours;

    @Column(name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

}
