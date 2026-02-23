package com.directrory.collegeDirectory.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title",nullable = false)
    private String title;
    @Column(name = "description",nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

//    @ManyToOne
//    @JoinColumn(name = "faculty_id")
//    private FacultyProfile faculty;

}
