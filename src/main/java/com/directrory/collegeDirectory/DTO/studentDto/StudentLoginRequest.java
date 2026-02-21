package com.directrory.collegeDirectory.DTO.studentDto;

import lombok.Data;

@Data
public class StudentLoginRequest {
    private String email;
    private String password;
}
