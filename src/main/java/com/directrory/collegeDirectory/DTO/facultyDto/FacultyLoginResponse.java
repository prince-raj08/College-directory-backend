package com.directrory.collegeDirectory.DTO.facultyDto;

import com.directrory.collegeDirectory.entity.Department;
import lombok.Data;

@Data
public class FacultyLoginResponse {
    private Long Id;
    private String name;
    private String email;
    private String phone;
    private Department department;
}
