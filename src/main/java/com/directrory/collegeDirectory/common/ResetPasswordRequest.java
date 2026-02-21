package com.directrory.collegeDirectory.common;

import lombok.Data;

@Data
public class ResetPasswordRequest {
    private String email;
    private String password;
}
