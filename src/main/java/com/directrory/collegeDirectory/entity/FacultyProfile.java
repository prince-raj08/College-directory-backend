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

    private String phone;

    private String officeHours;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

}
