package com.directrory.collegeDirectory.DTO.studentDto;

import lombok.Data;

@Data
public class StudentList {
    private Long id;
    private String name;
    private String email;
    private String year;
    private String department;
}
