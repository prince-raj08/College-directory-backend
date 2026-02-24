package com.directrory.collegeDirectory.DTO.facultyDto;


import lombok.Data;

@Data
public class FacultyLoginRequest {
    private String email;
    private String password;
}
