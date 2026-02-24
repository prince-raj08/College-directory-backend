package com.directrory.collegeDirectory.DTO.adminDto;

import lombok.Data;

@Data
public class AdminLoginRequest {
    private String email;
    private String password;
}
